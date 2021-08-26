USE onlineShop;

/* todo --------------filling in the table "Roles"---------------------*/
INSERT INTO Roles (role)
VALUES ('user');

INSERT INTO Roles (role)
VALUES ('admin');

/* todo --------------filling in the table "UserInformation"---------------------*/
INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Анжелика', 'Деркач', 'Валерьевна', 375293270981);

INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Виктор', 'Петров', 'Андреевич', 375293303651);

INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Екатерина', 'Козлова', 'Романовна', 375442114982);

/* todo --------------filling in the table "Promotions"---------------------*/
INSERT INTO promotions(name, description, discount, beginning_date, expiration_date, photo)
VALUES ('Летняя распродажа', 'Покупайте товары со скидкой во время летней распродажи!', 30, '2021-06-01',
        '2021-08-30', 'promotions/summer_sale.jpg');

INSERT INTO promotions(name, description, discount, beginning_date, expiration_date, photo)
VALUES ('Слушай музыку', 'Акция "Слушай музыку". Купите наушники со скидкой и слушайте любимую музыку где захотите!',
        50, '2021-07-28', '2021-08-28', 'promotions/listen_music.jpg');

/* todo --------------filling in the table "BankCards"---------------------*/
INSERT INTO BankCards (card_number, expiration_year, expiration_month, card_owner, cvv, balance)
VALUES (5106211010255079, 2023, 07, 'VICTOR PETROV', 778, 10023.56);

INSERT INTO BankCards (card_number, expiration_year, expiration_month, card_owner, cvv, balance)
VALUES (4276880099433504, 2022, 11, 'VICTOR PETROV', 291, 512.32);

INSERT INTO BankCards (card_number, expiration_year, expiration_month, card_owner, cvv, balance)
VALUES (5412751234123456, 2023, 02, 'EKATERINA KOZLOVA', 081, 22014.78);

/* todo --------------filling in the table "Users"---------------------*/
INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (1, 2, 'i.angelika897@gmail.com', SHA1('Angelika09042002'));

INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (2, 1, 'victor.petrov@gmail.com', SHA1('Victor123'));

INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (3, 1, '17ekaterina17@mail.ru', SHA1('000Kate'));

/* todo --------------filling in the table "UserOrders"---------------------*/
INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('г. Минск, ул. Красная д. 22', '2021-08-25', '2021-08-27', 'ожидается');

INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('г. Минск, ул. Якуба Коласа д. 28', '2021-08-24', '2021-08-27','ожидается');

INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('г. Минск, ул. Якуба Коласа д. 28', '2021-08-26', '2021-08-28', 'ожидается');

/* todo --------------filling in the table "Categories"---------------------*/
INSERT INTO Categories (category)
VALUES ('Ноутбуки');

INSERT INTO Categories (category)
VALUES ('Компьютерные мыши');

INSERT INTO Categories (category)
VALUES ('Наушники');

/* todo --------------filling in the table "Products"---------------------*/
INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (1, 'ASUS ROG Strix SCAR II GL504GM-ES026T', 4200.00, 1, 'laptops/ASUS_ROG_Strix_SCAR_II_GL504GM.jpg', 6,
        '15.6" 1920 x 1080 IPS, 144 Гц, несенсорный, Intel Core i7 8750H 2200 МГц, 16 ГБ, SSD+HDD 1000+256 ГБ, видеокарта NVIDIA GeForce GTX 1060 6 ГБ, Windows 10, цвет крышки черный');

INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (1, 'ASUS TUF Gaming A15 FA506IU-HN200', 2894.34, 1, 'laptops/ASUS_TUF_Gaming_A15_FA506IU.jpg', 5,
        '15.6" 1920 x 1080 IPS, 144 Гц, несенсорный, AMD Ryzen 7 4800H 2900 МГц, 16 ГБ, SSD 512 ГБ, видеокарта NVIDIA GeForce GTX 1660 Ti 6 ГБ, без ОС, цвет крышки черный');

INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (2, 'SmartBuy 612AG Red/Black (SBM-612AG-RK)', 20.76, 1,
        'computer_mouse/SmartBuy_612AG_RedBlack_(SBM-612AG-RK).jpg', 10,
        'Полноразмерная мышь для ПК, радио, сенсор оптический 2000 dpi, 6 кнопок, колесо с нажатием');

INSERT INTO Products (category_id, promotion_id, name, price, status, photo, orders_number, description)
VALUES (3, 2, 'A4Tech Bloody G500', 76.57, 1, 'headphones/A4Tech_Bloody_G500.jpg', 3,
        'Наушники с микрофоном, мониторные (охватывающие), портативные, 20-20000 Гц');

INSERT INTO Products (category_id, promotion_id, name, price, status, photo, orders_number, description)
VALUES (3, 2, 'Xiaomi Mi True Wireless Earbuds Basic 2 TWSEJ061LS', 42.00, 0,
        'headphones/Xiaomi_Mi_True_Wireless_Earbuds_Basic_2.jpg', 1,
        'Беспроводные наушники с микрофоном, внутриканальные, портативные, Bluetooth 5.0, 20-20000 Гц, время работы 4 ч');

/* todo --------------filling in the table "Orders"---------------------*/
INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (1, 3, 1, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (4, 3, 1, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (2, 3, 2, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (5, 2, 3, 2);