USE onlineShop;

/* todo --------------filling in the table "Roles"---------------------*/
INSERT INTO Roles (role)
VALUES ('user');

INSERT INTO Roles (role)
VALUES ('admin');

/* todo --------------filling in the table "UserInformation"---------------------*/
INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Angelika', 'Derkach', 'Valerievna', 375293270981);

INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Victor', 'Petrov', 'Andreevich', 375293303651);

INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Ekaterina', 'Kozlova', 'Romanovna', 375442114982);

/* todo --------------filling in the table "UserInformation"---------------------*/
INSERT INTO promotions(name, description, discount, beginning_date, expiration_date, photo)
VALUES ('Summer sale', 'Buy items at a discount during the Summer Sale!', 30, '2021-06-01', '2021-08-30',
        'promotions/summer_sale.jpg');

INSERT INTO promotions(name, description, discount, beginning_date, expiration_date, photo)
VALUES ('Listen music', '"Listen to music" action. Buy headphones at a discount and
listen to your favorite music wherever you want!', 50, '2021-07-24', '2021-08-24', 'promotions/listen_music.jpg');

/* todo --------------filling in the table "BankCards"---------------------*/
INSERT INTO BankCards (userInformation_id, card_number, expiration_year, explaration_month, card_owner)
VALUES (2, 5106211010255079, 23, 07, 'Victor Petrov');

INSERT INTO BankCards (userInformation_id, card_number, expiration_year, explaration_month, card_owner)
VALUES (2, 4276880099433504, 22, 11, 'Victor Petrov');

INSERT INTO BankCards (userInformation_id, card_number, expiration_year, explaration_month, card_owner)
VALUES (3, 5412751234123456, 23, 02, 'Ekaterina Kozlova');

/* todo --------------filling in the table "Users"---------------------*/
INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (1, 2, 'i.angelika897@gmail.com', SHA1('Angelika09042002'));

INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (2, 1, 'victor.petrov@gmail.com', SHA1('Victor123'));

INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (3, 1, '17ekaterina17@mail.ru', SHA1('000Kate'));

/* todo --------------filling in the table "UserOrders"---------------------*/
INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('Minsk city, Red Street 22', '2021-06-18', '2021-08-21', 'expected');

INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('Minsk city, Yakuba Kolas 28', '2021-06-16', '2021-08-24','expected');

INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('Minsk city, Yakuba Kolas 28', '2021-06-17', '2021-08-27', 'expected');

/* todo --------------filling in the table "Categories"---------------------*/
INSERT INTO Categories (category)
VALUES ('Laptops');

INSERT INTO Categories (category)
VALUES ('Computer mouse');

INSERT INTO Categories (category)
VALUES ('Headphones');

/* todo --------------filling in the table "Products"---------------------*/
INSERT INTO Products (category_id, name, price, status, photo, orders_number)
VALUES (1, 'ASUS ROG Strix SCAR II GL504GM-ES026T', 4200.00, 1, 'laptops/ASUS_ROG_Strix_SCAR_II_GL504GM-ES026T.jpg', 6);

INSERT INTO Products (category_id, name, price, status, photo, orders_number)
VALUES (1, 'ASUS TUF Gaming A15 FA506IU-HN200', 2894.34, 1, 'laptops/ASUS_TUF_Gaming_A15_FA506IU-HN200.jpg', 5);

INSERT INTO Products (category_id, name, price, status, photo, orders_number)
VALUES (2, 'SmartBuy 612AG Red/Black (SBM-612AG-RK)', 20.76, 1,
        'computer_mouse/SmartBuy_612AG_RedBlack_(SBM-612AG-RK).jpg', 10);

INSERT INTO Products (category_id, name, price, status, photo, orders_number)
VALUES (3, 'A4Tech Bloody G500', 76.57, 1, 'headphones/A4Tech_Bloody_G500.jpg', 3);

INSERT INTO Products (category_id, name, price, status, photo, orders_number)
VALUES (3, 'Xiaomi Mi True Wireless Earbuds Basic 2 TWSEJ061LS', 42.00, 0,
        'headphones/Xiaomi_Mi_True_Wireless_Earbuds_Basic_2_TWSEJ061LS.jpg', 1);

/* todo --------------filling in the table "Orders"---------------------*/
INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (1, 2, 1, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (4, 3, 1, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (2, 3, 2, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (5, 2, 3, 2);