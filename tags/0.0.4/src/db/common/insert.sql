INSERT INTO `generator`(`generatorName`, `generatorValue`) VALUES ('books', 0);

INSERT INTO `locales`(`language`, isSystem) VALUES ('ru', 1);
INSERT INTO `locales`(`language`) VALUES ('en');

INSERT INTO `stringculture`(`id`, `locale`, `value`) VALUES (1, 'ru', 'Государственный комитет ветеринарной медицины'),
                                    (2, 'ru', 'Одеський РСДВСКН'),
                                    (3, 'ru', 'Арцизький ПДВСКН'),
                                    (4, 'ru', 'Б-Дністровський ПДВСКН'),
                                    (5, 'ru', 'Березінський ПДВСКН'),
                                    (6, 'ru', 'Болградський ПДВСКН'),
                                    (7, 'ru', 'Велико-Михайлівський ПДВСКН'),
                                    (8, 'ru', 'Вознесенський ПДВСКН'),
                                    (9, 'ru', 'Звенігородський ПДВСКН'),
                                    (10, 'ru', 'Знам\'янський ПДВСКН'),
                                    (11, 'ru', 'Ізмаїльський ПДВСКН'),
                                    (12, 'ru', 'Іллічівський ПДВСКН'),
                                    (13, 'ru', 'Каховський ПДВСКН'),
                                    (14, 'ru', 'Кілійський ПДВСКН'),
                                    (15, 'ru', 'Кіровоградський ПДВСКН'),
                                    (16, 'ru', 'Кодимський ПДВСКН'),
                                    (17, 'ru', 'Котовський ПДВСКН'),
                                    (18, 'ru', 'Красно-Окнянський ПДВСКН'),
                                    (19, 'ru', 'Миколаївський ПДВСКН'),
                                    (20, 'ru', 'Одеський ПДВСКН'),
                                    (21, 'ru', 'Первомайский ПДВСКН'),
                                    (22, 'ru', 'Роздільнянський ПДВСКН'),
                                    (23, 'ru', 'Ренійський ПДВСКН'),
                                    (24, 'ru', 'Скадовський ПДВСКН'),
                                    (25, 'ru', 'Старокозацький ПДВСКН'),
                                    (26, 'ru', 'Вапнярський ПДВСКН'),
                                    (27, 'ru', 'Удобнянський ПДВСКН'),
                                    (28, 'ru', 'Уманський ПДВСКН'),
                                    (29, 'ru', 'Херсонський ПДВСКН'),
                                    (30, 'ru', 'Черкаський ПДВСКН'),
                                    (31, 'ru', 'Шевченківський ПДВСКН'),
                                    (32, 'ru', 'Южненський ПДВСКН');


INSERT INTO `department`(`name`, `parent_id`, `level`) VALUES (1, NULL, 1),
                                                            (2, 1, 2),
                                                            (3, 2, 3),
                                                            (4, 2, 3),
                                                            (5, 2, 3),
                                                            (6, 2, 3),
                                                            (7, 2, 3),
                                                            (8, 2, 3),
                                                            (9, 2, 3),
                                                            (10, 2, 3),
                                                            (11, 2, 3),
                                                            (12, 2, 3),
                                                            (13, 2, 3),
                                                            (14, 2, 3),
                                                            (15, 2, 3),
                                                            (16, 2, 3),
                                                            (17, 2, 3),
                                                            (18, 2, 3),
                                                            (19, 2, 3),
                                                            (20, 2, 3),
                                                            (21, 2, 3),
                                                            (22, 2, 3),
                                                            (23, 2, 3),
                                                            (24, 2, 3),
                                                            (25, 2, 3),
                                                            (26, 2, 3),
                                                            (27, 2, 3),
                                                            (28, 2, 3),
                                                            (29, 2, 3),
                                                            (30, 2, 3),
                                                            (31, 2, 3),
                                                            (32, 2, 3);

INSERT INTO `stringculture`(`id`, `locale`, `value`) VALUES (33,'en','импорт'),(33,'ru','импорт'),
(34,'en','экспорт'),(34,'ru','экспорт'),(35,'en','транзит'),(35,'ru','транзит'),(36,'en','импортный транзит'),(36,'ru','импортный транзит');
/* Common movement types(for reports):
    id  movement type
    1   импорт
    2   экспорт
    3   транзит
    4   импортный транзит
*/
INSERT INTO `movement_type`(`id`, `name`) VALUES (1,33),(2,34),(3,35),(4,36);

INSERT INTO `passing_border_point`(`name`, `department_id`) VALUES

('Пункт 3.1', 3),('Пункт 3.2', 3),('Пункт 3.3', 3),
('Пункт 4.1', 4),('Пункт 4.2', 4),('Пункт 4.3', 4),
('Пункт 5.1', 5),('Пункт 5.2', 5),('Пункт 5.3', 5),
('Пункт 6.1', 6),('Пункт 6.2', 6),('Пункт 6.3', 6),
('Пункт 7.1', 7),('Пункт 7.2', 7),('Пункт 7.3', 7),
('Пункт 8.1', 8),('Пункт 8.2', 8),('Пункт 8.3', 8),
('Пункт 9.1', 9),('Пункт 9.2', 9),('Пункт 9.3', 9),
('Пункт 10.1', 10),('Пункт 10.2', 10),('Пункт 10.3', 10),
('Пункт 11.1', 11),('Пункт 11.2', 11),('Пункт 11.3', 11),
('Пункт 12.1', 12),('Пункт 12.2', 12),('Пункт 12.3', 12),
('Пункт 13.1', 13),('Пункт 13.2', 13),('Пункт 13.3', 13),
('Пункт 14.1', 14),('Пункт 14.2', 14),('Пункт 14.3', 14),
('Пункт 15.1', 15),('Пункт 15.2', 15),('Пункт 15.3', 15),
('Пункт 16.1', 16),('Пункт 16.2', 16),('Пункт 16.3', 16),
('Пункт 17.1', 17),('Пункт 17.2', 17),('Пункт 17.3', 17),
('Пункт 18.1', 18),('Пункт 18.2', 18),('Пункт 18.3', 18),
('Пункт 19.1', 19),('Пункт 19.2', 19),('Пункт 19.3', 19),
('Пункт 20.1', 20),('Пункт 20.2', 20),('Пункт 20.3', 20),
('Пункт 21.1', 21),('Пункт 21.2', 21),('Пункт 21.3', 21),
('Пункт 22.1', 22),('Пункт 22.2', 22),('Пункт 22.3', 22),
('Пункт 23.1', 23),('Пункт 23.2', 23),('Пункт 23.3', 23),
('Пункт 24.1', 24),('Пункт 24.2', 24),('Пункт 24.3', 24),
('Пункт 25.1', 25),('Пункт 25.2', 25),('Пункт 25.3', 25),
('Пункт 26.1', 26),('Пункт 26.2', 26),('Пункт 26.3', 26),
('Пункт 27.1', 27),('Пункт 27.2', 27),('Пункт 27.3', 27),
('Пункт 28.1', 28),('Пункт 28.2', 28),('Пункт 28.3', 28),
('Пункт 29.1', 29),('Пункт 29.2', 29),('Пункт 29.3', 29),
('Пункт 30.1', 30),('Пункт 30.2', 30),('Пункт 30.3', 30),
('Пункт 31.1', 31),('Пункт 31.2', 31),('Пункт 31.3', 31),
('Пункт 32.1', 32),('Пункт 32.2', 32),('Пункт 32.3', 32);

INSERT INTO `stringculture`(`id`, `locale`, `value`) VALUES (37, 'ru', 'Администратор'),
                                    (37, 'en', 'Administrator'),
                                    (38, 'ru', 'Лікар вет.медицини'),
                                    (39, 'ru', 'Провідний лікар вет.медицини'),
                                    (40, 'ru', 'Начальник пункта'),
                                    (41, 'ru', 'Начальник віддела'),
                                    (42, 'ru', 'Начальник региональной служби'),
                                    (43, 'ru', 'Перший заступник начальника региональной служби'),
                                    (44, 'ru', 'Заступник начальника региональной служби');

INSERT INTO `job`(`id`, `name`) VALUES (1,37),(2,38),(3,39),(4,40),(5,41),(6,42),(7,43),(8,44);

UPDATE `generator` SET `generatorValue` = 44 WHERE `generatorName` = 'books';
