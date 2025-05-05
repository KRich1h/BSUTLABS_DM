import xml.etree.ElementTree as ET
from decimal import Decimal

def process_xml(xml_file):
    try:
        tree = ET.parse(xml_file)
        root = tree.getroot()
        
        books = []
        total_price = Decimal('0')
        
        # Чтение данных
        for book in root.findall('book'):
            book_data = {
                'id': book.get('id'),
                'title': book.find('title').text,
                'author': book.find('author').text,
                'year': int(book.find('year').text),
                'genre': book.find('genre').text,
                'price': Decimal(book.find('price').text)
            }
            books.append(book_data)
            total_price += book_data['price']
            
            print(f"Книга: {book_data['title']}")
            print(f"Автор: {book_data['author']}")
            print(f"Год: {book_data['year']}")
            print(f"Жанр: {book_data['genre']}")
            print(f"Цена: ${book_data['price']:.2f}\n")
        
        # Средняя цена
        avg_price = total_price / len(books)
        print(f"Средняя цена: ${avg_price:.2f}")
        
        # Фильтрация
        filter_genre = input("Введите жанр для фильтрации (оставьте пустым, чтобы пропустить): ").strip()
        if filter_genre:
            filtered = [b for b in books if b['genre'].lower() == filter_genre.lower()]
            print(f"\nНайдено {len(filtered)} книг в жанре '{filter_genre}':")
            for b in filtered:
                print(f"- {b['title']} ({b['year']})")
                
    except FileNotFoundError:
        print("Ошибка: файл не найден.")
    except ET.ParseError as e:
        print(f"Ошибка парсинга XML: {e.msg}")
        print(f"Строка {e.position[0]}, колонка {e.position[1]}")
    except Exception as e:
        print(f"Неизвестная ошибка: {e}")

process_xml("library.xml")