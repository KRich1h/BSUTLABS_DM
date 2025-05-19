from kafka import KafkaProducer
import json

producer = KafkaProducer(
    bootstrap_servers="localhost:9092",
    value_serializer=lambda v: json.dumps(v).encode("utf-8")
)

while True:
    user_input = input("Введите JSON-сообщение (или 'exit' для выхода): ")
    if user_input.lower() == "exit":
        break
    try:
        message = json.loads(user_input)  # Проверяем, является ли ввод корректным JSON
        producer.send("user_actions", value=message)
        print("Сообщение отправлено:", message)
    except json.JSONDecodeError:
        print("Ошибка: введенные данные не являются корректным JSON.")

producer.flush()
print("Продюсер завершил работу.")

{"user_id": 102, "action": "purchase", "timestamp": "2023-10-01T12:00:00"}
