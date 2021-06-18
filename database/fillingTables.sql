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
INSERT INTO UserOrders (user_id, address, order_date, delivery_date)
VALUES (2, 'Minsk city, Red Street 22', '2021-06-18', '2021-08-21');

INSERT INTO UserOrders (user_id, address, order_date, delivery_date)
VALUES (3, 'Minsk city, Yakuba Kolas 28', '2021-06-16', '2021-08-24');

INSERT INTO UserOrders (user_id, address, order_date, delivery_date)
VALUES (3, 'Minsk city, Yakuba Kolas 28', '2021-06-17', '2021-08-27');

/* todo --------------filling in the table "Categories"---------------------*/
INSERT INTO Categories (category)
VALUES ('Laptops');

INSERT INTO Categories (category)
VALUES ('Computer mouse');

INSERT INTO Categories (category)
VALUES ('Headphones');

/* todo --------------filling in the table "Products"---------------------*/
INSERT INTO Products (category_id, name, price, status, photo)
VALUES (1, 'ASUS ROG Strix SCAR II GL504GM-ES026T', 4200.00, 1, 'laptops/ASUS_ROG_Strix_SCAR_II_GL504GM-ES026T.jpg');

INSERT INTO Products (category_id, name, price, status, photo)
VALUES (1, 'ASUS TUF Gaming A15 FA506IU-HN200', 2894.34, 1, 'laptops/ASUS_TUF_Gaming_A15_FA506IU-HN200.jpg');

INSERT INTO Products (category_id, name, price, status, photo)
VALUES (2, 'SmartBuy 612AG Red/Black (SBM-612AG-RK)', 20.76, 1,
        'computer_mouse/SmartBuy_612AG_RedBlack_(SBM-612AG-RK).jpg');

INSERT INTO Products (category_id, name, price, status, photo)
VALUES (3, 'A4Tech Bloody G500', 76.57, 1, 'headphones/A4Tech_Bloody_G500.jpg');

INSERT INTO Products (category_id, name, price, status, photo)
VALUES (3, 'Xiaomi Mi True Wireless Earbuds Basic 2 TWSEJ061LS', 42.00, 0,
        'headphones/Xiaomi_Mi_True_Wireless_Earbuds_Basic_2_TWSEJ061LS.jpg');

/* todo --------------filling in the table "Orders"---------------------*/
INSERT INTO Orders (product_id, userOrder_id, number)
VALUES (1, 1, 1);

INSERT INTO Orders (product_id, userOrder_id, number)
VALUES (4, 1, 1);

INSERT INTO Orders (product_id, userOrder_id, number)
VALUES (2, 2, 1);

INSERT INTO Orders (product_id, userOrder_id, number)
VALUES (5, 3, 2);