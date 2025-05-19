import uuid
from kafka import KafkaConsumer, KafkaProducer
import mysql.connector
import json
from collections import Counter

# Подключение к MySQL
conn = mysql.connector.connect(host="localhost", user="user", password="password", database="mydb")
cursor = conn.cursor()

# Функция сохранения сообщений в базу
def save_to_db(message):
    data = json.dumps(message)
    cursor.execute("INSERT INTO user_actions (data) VALUES (%s)", (data,))
    conn.commit()

# Инициализация консьюмера
consumer = KafkaConsumer(
    "user_actions",
    bootstrap_servers="localhost:9092",
    group_id="consumer_group",
    client_id=f"consumer-{uuid.uuid4()}",
    auto_offset_reset="earliest",
    enable_auto_commit=True,
    value_deserializer=lambda v: json.loads(v.decode("utf-8"))
)

# Инициализация продюсера для Dead Letter Topic (DLT)
producer = KafkaProducer(
    bootstrap_servers="localhost:9092",
    value_serializer=lambda v: json.dumps(v).encode("utf-8")
)

print("Консьюмер запущен. Ожидание сообщений...")

# Счетчики
message_count = 0
action_counter = Counter()

# Чтение сообщений
for message in consumer:
    try:
        print("Получено сообщение:", message.value)

        # Проверка корректности сообщения
        data = message.value
        if not isinstance(data, dict) or "action" not in data:
            raise ValueError("Некорректное сообщение!")

        action = data["action"]
        action_counter[action] += 1
        message_count += 1

        # Сохранение в базу
        save_to_db(data)

        # Вывод отдельных сообщений о покупке
        if action == "purchase":
            print(f"Received purchase action: {data}")

    except Exception as e:
        print(f"Ошибка обработки сообщения: {message.value} -> {e}")
        producer.send("user_actions_dlt", value=message.value)  # Отправка в DLT

    # Вывод статистики после обработки каждого сообщения
    print(f"\nВсего обработано сообщений: {message_count}")
    print(f"Частота действий: {action_counter}\n")

# Закрытие соединения с базой при завершении
conn.close()



