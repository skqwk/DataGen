# Командный проект по курсу "Технология разработки программных приложений" в РТУ МИРЭА
## Описание
DataGen - сервис для генерации наборов случайных данных. Данные могут представляться в виде:
- таблиц
- XML
- json-объектов
- SQL-запросов

Размер, вид и тип, генерируемых наборов определяется пользователем.

## Оглавление
1. [Структура проекта](#ref1)
1. [Как это должно работать?](#ref2)
1. [Архитектура проекта](#ref3)
## Содержание

### <a name="ref1"></a> 1. Структура проекта

DataGen состоит из следующих частей:
1. API, к которому можно обратиться с помощью запросов, указывая все необходимые параметры для генерации.
2. UI, через который пользователь может легко параметризировать генерируемый набор данных.

### <a name="ref2"></a> 2. Как это должно работать?


**Пример использования**

Пользователь желает сгенерировать запрос в базу данных для добавления 10 сущностей студентов.

Через DataGen пользователь определяет:
- Размер данных: 10
- Название сущности: Студент
- Название поля : тип поля
  - Имя: Имя (ru)
  - Фамилия: Фамилия (ru)
  - Отчество: Отчество (ru)
  - Возраст: Целое число [17, 32]
  - Номер курса: Целое число [1, 5]
  - Email: Email
  - Город: Город
  - Страна: Страна
  - Средний балл: Действительное число [2.0, 5.0]
  - Специальность: Случайная из
      - Программная инженерия
      - Прикладная информатика
      - Вычислительная техника
      - Информационные системы

UI может выглядеть следующим образом:

![image](https://user-images.githubusercontent.com/71013663/161836843-3819ebfe-ff38-44e5-be0e-f9518475d837.png)

### <a name="ref3"></a> 3. Архитектура проекта

Структура:
- База данных / Хранилище готовых данных
  - DAO для номинальных данных
  - Парсеры файлов
- Сервер
  - Абстракция для сущности данных
  - Генератор случайных интервальных данных
  - Генератор строковых данных по шаблону
  - Нормализатор данных (для форматирования)
  - Генератор дат
  - Конвертатор данных
- Клиент
  - Поля для ввода
  - Вывод информации
  - Валидация полей

