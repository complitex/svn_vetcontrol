INSERT INTO `generator`(`generatorName`, `generatorValue`) VALUES ('books', 0);
INSERT INTO `generator`(`generatorName`, `generatorValue`) VALUES ('arrest_document', 0);
INSERT INTO `generator`(`generatorName`, `generatorValue`) VALUES ('cargo', 0);
INSERT INTO `generator`(`generatorName`, `generatorValue`) VALUES ('document_cargo', 0);
INSERT INTO `generator`(`generatorName`, `generatorValue`) VALUES ('vehicle', 0);
INSERT INTO `generator`(`generatorName`, `generatorValue`) VALUES ('change_detail', 0);

INSERT INTO `locales`(`language`, isSystem) VALUES ('ru', 1);
INSERT INTO `locales`(`language`) VALUES ('en');

-- departments
INSERT INTO `stringculture`(`id`, `locale`, `value`) VALUES (1, 'ru', 'Государственный комитет ветеринарной медицины'),
                                    (2, 'ru', 'Одеський РСДВСКН'),
                                    (3, 'ru', 'ПДВСКН №1 Арцизький'),
                                    (4, 'ru', 'ПДВСКН №2 Б-Дністровський'),
                                    (5, 'ru', 'ПДВСКН №3 Березінський'),
                                    (6, 'ru', 'ПДВСКН №4 Болградський'),
                                    (7, 'ru', 'ПДВСКН №5 Вапнярський'),
                                    (8, 'ru', 'ПДВСКН №6 Велико-Михайлівський, Красно-Окнянський'),
                                    (9, 'ru', 'ПДВСКН №7 Звенігородський'),
                                    (10, 'ru', 'ПДВСКН №8 Ізмаїльський'),
                                    (11, 'ru', 'ПДВСКН №9 Іллічівський IМТП'),
                                    (12, 'ru', 'ПДВСКН №10 Іллічівський Паром'),
                                    (13, 'ru', 'ПДВСКН №11 Іллічівський Рибпорт'),
                                    (14, 'ru', 'ПДВСКН №12 Каховський'),
                                    (15, 'ru', 'ПДВСКН №13 Кілійський'),
                                    (16, 'ru', 'ПДВСКН №14 Знам\'янський, Кіровоградський'),
                                    (17, 'ru', 'ПДВСКН №15 Котовський, Кодимський'),
                                    (18, 'ru', 'ПДВСКН №16 Миколаївський порт'),
                                    (19, 'ru', 'ПДВСКН №17 Миколаївський жд'),
                                    (20, 'ru', 'ПДВСКН №18 Одеський ОМТП'),
                                    (21, 'ru', 'ПДВСКН №19 Одеський Аеропорт'),
                                    (22, 'ru', 'ПДВСКН №20 Одеський жд'),
                                    (23, 'ru', 'ПДВСКН №21 Ренійський'),
                                    (24, 'ru', 'ПДВСКН №22 Роздільнянський'),
                                    (25, 'ru', 'ПДВСКН №23 Скадовський'),
                                    (26, 'ru', 'ПДВСКН №24 Старокозацький'),
                                    (27, 'ru', 'ПДВСКН №25 Удобнянський'),
                                    (28, 'ru', 'ПДВСКН №26 Уманський'),
                                    (29, 'ru', 'ПДВСКН №27 Херсонський'),
                                    (30, 'ru', 'ПДВСКН №28 Черкаський'),
                                    (31, 'ru', 'ПДВСКН №29 Шевченківський'),
                                    (32, 'ru', 'ПДВСКН №30 Южненський'),
                                    (33, 'ru', 'ПДВСКН №31 Вознесенський, Первомайский'),
                                    (34, 'ru', 'Відділ обеспечення'),
                                    (35, 'ru', 'Контрольно-аналитичний відділ');


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
                                                            (32, 2, 3),
                                                            (33, 2, 3),
                                                            (34, 2, 3),
                                                            (35, 2, 3);

-- cargo types
INSERT INTO `stringculture`(`id`, `locale`, `value`) VALUES
(36, 'ru', 'Коні, віслюки, мули та лошаки, живі'),
(37, 'ru', 'Велика рогата худоба жива'),
(38, 'ru', 'Свині живі'),
(39, 'ru', 'Вівці або кози живі'),
(40, 'ru', 'Свійська птиця жива (півні, кури, качки, гуси, індики, індички та цесарки)'),
(41, 'ru', 'Інші тварини живі:'),
(42, 'ru', 'тварини, що поставляються для зоопарків'),
(43, 'ru', 'інші'),
(44, 'ru', 'Яловичина свіжа або охолоджена'),
(45, 'ru', 'Яловичина морожена'),
(46, 'ru', 'Свинина свіжа, охолоджена або морожена'),
(47, 'ru', 'Баранина або козлятина, свіжа, охолоджена або морожена'),
(48, 'ru', 'М''ясо коней (конина), віслюків, мулів або лошаків, свіже, охолоджене або морожене'),
(49, 'ru', 'Субпродукти харчові великої рогатої худоби, свиней, овець, кіз, коней, віслюків, мулів або лошаків, свіжі, охолоджені або морожені'),
(50, 'ru', 'М''ясо та харчові субпродукти свійської птиці товарної позиції 0105, свіжі, охолоджені або морожені'),
(51, 'ru', 'Інші м''ясо та харчові субпродукти, свіжі, охолоджені або морожені:'),
(52, 'ru', 'кролятина або зайчатина'),
(53, 'ru', 'жаб''ячі лапки'),
(54, 'ru', 'інші'),
(55, 'ru', 'Сало без пісних частин, свинячий жир та жир свійської птиці, не витоплені і не виділені іншим способом, свіжі або охолоджені, морожені, солоні або у розсолі, сушені або копчені'),
(56, 'ru', 'М''ясо та харчові субпродукти, солоні або у розсолі, сушені або копчені; харчове борошно з м''яса або субпродуктів'),
(57, 'ru', 'Жива риба:'),
(58, 'ru', 'декоративна риба'),
(59, 'ru', 'інша'),
(60, 'ru', 'морська'),
(61, 'ru', 'Риба свіжа або охолоджена, крім рибного філе та іншого м''яса риб товарної позиції 0304:'),
(62, 'ru', 'інші'),
(63, 'ru', 'інша'),
(64, 'ru', 'Риба морожена, крім рибного філе та іншого м''яса риб товарної позиції 0304'),
(65, 'ru', 'Філе рибне та інше м''ясо риб (включаючи фарш), свіже, охолоджене або морожене'),
(66, 'ru', 'Риба сушена, солона або у розсолі; риба гарячого або холодного копчення; рибні борошно, порошок та гранули, придатні для харчування'),
(67, 'ru', 'Ракоподібні з панцирами або без панцирів, живі, свіжі, охолоджені, морожені, сушені, солоні або у розсолі; ракоподібні у панцирах, варені у воді або на парі, охолоджені або неохолоджені, морожені, сушені, солоні або у розсолі; борошно, порошок та гранули з ракоподібних, придатні для харчування:'),
(68, 'ru', 'креветки'),
(69, 'ru', 'краби'),
(70, 'ru', 'інші, включаючи борошно, порошок та гранули з ракоподібних, придатні для харчування'),
(71, 'ru', 'креветки'),
(72, 'ru', 'краби'),
(73, 'ru', 'інші, включаючи борошно, порошок та гранули з ракоподібних, придатні для харчування'),
(74, 'ru', 'Молюски, відділені або не відділені від черепашок, живі, свіжі, охолоджені, морожені, сушені, солоні або у розсолі; інші водяні безхребетні, крім ракоподібних та молюсків, живі, свіжі, охолоджені, морожені, сушені, солоні або у розсолі; борошно, порошок та гранули з інших водяних безхребетних, крім ракоподібних та молюсків, придатні для харчування:'),
(75, 'ru', 'устриці'),
(76, 'ru', 'живі, свіжі або охолоджені'),
(77, 'ru', 'живі, свіжі або охолоджені'),
(78, 'ru', 'інші'),
(79, 'ru', 'равлики, крім морських'),
(80, 'ru', 'водяні безхребетні інші'),
(81, 'ru', 'інші'),
(82, 'ru', 'Молоко та вершки, незгущені і без додання цукру чи інших підсолоджувальних речовин'),
(83, 'ru', 'Молоко та вершки, згущені або з доданням цукру чи інших підсолоджувальних речовин'),
(84, 'ru', 'Маслянка, коагульовані молоко та вершки, йогурт, кефір та інші ферментовані або сквашені молоко та вершки (бактеріальними заквасками), згущені або незгущені, або з доданням цукру чи інших підсолоджувальних речовин, або ароматизовані чи неароматизовані, або з доданням фруктів, горіхів чи какао'),
(85, 'ru', 'Молочна сироватка, згущена або незгущена, з доданням чи без додання цукру чи інших підсолоджувальних речовин; продукти, які складаються з натуральних компонентів частин молока, з доданням чи без додання цукру чи інших підсолоджувальних речовин, в іншому місці непойменовані'),
(86, 'ru', 'Масло вершкове та інші жири, вироблені з молока; молочні пасти'),
(87, 'ru', 'Сири всіх видів та кисломолочний сир'),
(88, 'ru', 'Яйця птиці у шкаралупі, свіжі, консервовані або варені'),
(89, 'ru', 'Яйця птиці без шкаралупи та яєчні жовтки, свіжі, сушені, варені у воді або на парі, формовані, морожені або консервовані іншим способом, з доданням чи без додання цукру чи інших підсолоджувальних речовин'),
(90, 'ru', 'Мед натуральний'),
(91, 'ru', 'Харчові продукти тваринного походження, в іншому місці непойменовані'),
(92, 'ru', 'Людське волосся необроблене, мите чи немите, або знежирене чи незнежирене; відходи волосся"'),
(93, 'ru', 'Щетина свійських або диких свиней; борсучий волос та інший волос, що використовується для виробництва щіток; відходи щетини або волосу'),
(94, 'ru', 'Кінський волос та його відходи, у тому числі у вигляді полотна, з підосновою чи без неї'),
(95, 'ru', 'Кишки, сечові міхурі та шлунки тварин, цілі або шматками, крім риб''ячих, свіжі, охолоджені, морожені, солоні або у розсолі, сушені або копчені'),
(96, 'ru', 'Шкурки та інші частини птахів, вкриті пір''ям або пухом, пір''я та частини пір''я (обрізані чи необрізані) та пух, очищені або неочищені, дезінфіковані чи оброблені з метою їх збереження, але які не проходили подальшої обробки; порошок та відходи пір''я або частин пір''я'),
(97, 'ru', 'Кістки та роги, необроблені, знежирені, які пройшли первинну обробку (але без надання форми), оброблені кислотою або дежелатиновані; порошок та відходи цих продуктів"'),
(98, 'ru', 'Слонова кістка, черепаховий панцир, вус китовий (включаючи бахрому) або інших морських ссавців, роги, роги оленя, копита, нігті, кігті та дзьоби, необроблені або які пройшли первинну обробку, але без надання форми; порошок та відходи цих матеріалів'),
(99, 'ru', 'Корали та аналогічні матеріали, необроблені або які пройшли первинну обробку; черепашки та панцирі молюсків, ракоподібних чи голкошкірих, кістки каракатиць, необроблені або які пройшли первинну обробку, але без надання форми, порошок та відходи цих матеріалів'),
(100, 'ru', 'Губки натуральні тваринного походження'),
(101, 'ru', 'Амбра сіра, струмина боброва, цівета та мускус; шпанські мушки; жовч, у тому числі суха; залози та інші продукти тваринного походження, що використовуються для виготовлення фармацевтичних засобів, свіжі, охолоджені, морожені або оброблені іншим способом, консервовані'),
(102, 'ru', 'Продукти тваринного походження, не включені до інших угруповань; мертві тварини групи 01 або 03, непридатні для харчування'),
(103, 'ru', 'Солома та полова зернових, необроблені, подрібнені або неподрібнені, розмелені або нерозмелені, пресовані або у вигляді таблеток'),
(104, 'ru', 'Бруква кормова, буряк кормовий, кормові коренеплоди, сіно, люцерна, конюшина, еспарцет, капуста кормова, люпин, вика та аналогічні кормові продукти, пресовані у вигляді таблеток або непресовані'),
(105, 'ru', 'Матеріали рослинного походження, що використовуються головним чином для виробництва віників або мітел (наприклад сорго, п''ясава, пирій, істль), у в''язках, пучках або жмутах'),
(106, 'ru', 'Жир свинячий (включаючи топлене сало) та жир свійської птиці, крім жиру товарної позиції 0209 або1503'),
(107, 'ru', 'Жир великої рогатої худоби, овечий або козячий, крім жиру товарної позиції 1503'),
(108, 'ru', 'Лярд-стеарин, смалець, олеостеарин, олеомаргарин та масло тварин, не емульговані, не змішані, не приготовлені іншим способом'),
(109, 'ru', 'Жири і масла та їх фракції з риби або морських ссавців, рафіновані або нерафіновані, але без зміни їх хімічного складу'),
(110, 'ru', 'Жир з овечого випоту (жиропіт) та побічні жирові речовини, включаючи ланолін'),
(111, 'ru', 'Інші тваринні жири і масла та їх фракції, рафіновані або нерафіновані, але без зміни їх хімічного складу'),
(112, 'ru', 'Жири і масла тваринні або рослинні та їх фракції, частково або повністю гідрогенізовані, інтеретерифіковані, реетерифіковані або елаїдинізовані, рафіновані або нерафіновані, але не піддані подальшій обробці'),
(113, 'ru', 'Маргарин; харчові суміші або продукти з тваринних та рослинних жирів, масел та олій або фракцій жирів, масел чи олій з цієї групи, крім харчових жирів і масел та їх фракцій товарної позиції 1516'),
(114, 'ru', 'Жири і олії тваринні або рослинні та їх фракції, варені, окислені, зневоднені, оброблені сірчаною кислотою, окислені струменем повітря або хімічно модифіковані, крім продуктів товарної позиції 1516; нехарчові суміші або продукти з тваринних або рослинних жирів, масел та олій або фракцій різних жирів, масел чи олій з цієї групи, не включені до інших угруповань'),
(115, 'ru', 'Воски рослинні (крім тригліцеридів), віск бджолиний та воски і спермацети інших комах, рафіновані чи нерафіновані або пофарбовані чи непофарбовані'),
(116, 'ru', 'Дегра; залишки після обробки жирових речовин або воску тваринного чи рослинного походження'),
(117, 'ru', 'Сосиски, ковбаси та аналогічні вироби з м''яса, м''ясних субпродуктів чи крові; готові харчові продукти, виготовлені на основі цих виробів'),
(118, 'ru', 'Готові чи консервовані продукти з м''яса, м''ясних субпродуктів або крові, інші'),
(119, 'ru', 'Екстракти та соки з м''яса, риби або ракоподібних, молюсків чи інших водяних безхребетних'),
(120, 'ru', 'Готова або консервована риба; ікра осетрових (чорна ікра) та її замінники, виготовлені з ікри інших риб'),
(121, 'ru', 'Готові або консервовані ракоподібні, молюски та інші водяні безхребетні'),
(122, 'ru', 'Патока [меляса], одержана внаслідок екстракції або рафінування цукру'),
(123, 'ru', 'Супи чи бульйони готові і заготовки для їх приготування; гомогенізовані складені харчові продукти'),
(124, 'ru', 'Морозиво та інші види харчового льоду, що містять або не містять какао'),
(125, 'ru', 'Борошно, крупи та гранули з м''яса або м''ясних субпродуктів, риби або ракоподібних, молюсків чи інших водяних безхребетних, не придатні для споживання; шкварки'),
(126, 'ru', 'Висівки, кормове борошно та інші відходи від просіювання, мелення або інших способів обробки зерна зернових або бобових культур, гранульовані чи негранульовані'),
(127, 'ru', 'Відходи виробництва крохмалю та аналогічні відходи, бурякова макуха, макуха цукрової тростини та інші відходи виробництва цукру, барда та інші відходи пивоваріння і винокуріння, гранульовані або негранульовані'),
(128, 'ru', 'Макуха та інші тверді відходи, одержані під час добування соєвої олії, мелені або немелені, негранульовані або гранульовані'),
(129, 'ru', 'Макуха та інші тверді відходи, одержані під час добування арахісової олії, мелені або немелені, негранульовані або гранульовані'),
(130, 'ru', 'Макуха та інші тверді відходи, одержані під час добування рослинних жирів та олій, за винятком відходів товарної позиції 2304 або 2305, пресовані у брикети, мелені або немелені, негранульовані або гранульовані'),
(131, 'ru', 'Продукти рослинного походження і рослинні відходи, рослинні залишки і аналогічні продукти, негранульовані або гранульовані, що використовуються для годівлі тварин, не включені до інших угруповань'),
(132, 'ru', 'Продукти, що використовуються для годівлі тварин:'),
(133, 'ru', 'буряковий жом з доданням меляси'),
(134, 'ru', 'Залози та інші органи, призначені для органотерапевтичних цілей, висушені, подрібнені або не подрібнені у порошок; екстракти залоз або інших органів або їх секретів, призначені для органотерапевтичних цілей; гепарин та його солі; інші речовини людського або тваринного походження, призначені для терапевтичного або профілактичного застосування, не включені до інших угруповань'),
(135, 'ru', 'Кров людей; кров тварин, приготовлена для терапевтичного, профілактичного або діагностичного застосування; сироватки імунні (антисироватки), інші фракції крові та модифіковані імунологічні продукти, у тому числі одержані біотехнологічними процесами; вакцини, токсини, культури мікроорганізмів (крім дріжджів) та аналогічна продукція:'),
(136, 'ru', 'культури мікроорганізмів'),
(137, 'ru', 'Лікарські засоби [ліки] (за винятком товарів, включених до товарних позицій 3002, 3005 або 3006), що містять змішані продукти для терапевтичного або профілактичного застосування, але не у дозованому вигляді і не розфасовані для роздрібної торгівлі:'),
(138, 'ru', 'інші лікарські засоби, що містять вітаміни або інші сполуки товарної позиції 2936'),
(139, 'ru', 'Добрива тваринного або рослинного походження, у суміші або ні, піддані хімічній обробці або ні; добрива, одержані у результаті змішування або хімічної обробки речовин тваринного або рослинного походження'),
(140, 'ru', 'Казеїн, казеїнати та інші похідні казеїнів; казеїнові клеї'),
(141, 'ru', 'Альбуміни (білки), включаючи концентрати з кількох сироваткових білків з вмістом понад 80 мас.% сироваткових білків у перерахунку на суху речовину; альбумінати та інші похідні альбумінів'),
(142, 'ru', 'Желатин (включаючи вироблений у формі квадратних або прямокутних листків, з поверхневою обробкою або без обробки, забарвлений або незабарвлений) та його похідні; риб''ячий клей; інші клеї тваринного походження, за винятком казеїнових клеїв товарної позиції 3501'),
(143, 'ru', 'Пептони та їх похідні; інші білкові речовини та їх похідні, не включені до інших угруповань; порошок із шкіри, оброблений чи не оброблений хромом'),
(144, 'ru', 'Шкури необроблені великої рогатої худоби або тварин родини конячих (свіжі або солоні, сушені, оброблені вапном, протравлені чи консервовані іншим способом, але не дублені, не вироблені під пергамент і не піддані подальшій обробці), з волосяним покровом або без волосяного покрову, спілок або неспілок'),
(145, 'ru', 'Необроблені шкури овець або шкурки ягнят (свіжі або солоні, сушені, оброблені вапном, зольні, пікельовані чи консервовані іншим способом, але не дублені, не вироблені під пергамент і не піддані подальшій обробці), з вовняним покровом або без вовняного покрову, спілок або неспілок, крім зазначених у примітці 1в до цієї групи'),
(146, 'ru', 'Інші шкури та шкіри необроблені (шкірсировина) (свіжа або солона, сушена, оброблена вапном, зольна, пікельована чи консервована іншим способом, але не дублена, не вироблена під пергамент і не піддана подальшій обробці), з волосяним покровом або без волосяного покрову, спілок або неспілок, крім зазначених у примітках 1б або 1в до цієї групи'),
(147, 'ru', 'Шкіра із шкур овець чи шкурок ягнят, без вовняного покрову, крім шкіри товарної позиції 4108 або 4109'),
(148, 'ru', 'Шкіра із шкур кіз чи шкурок козенят, без волосяного покрову, крім шкіри товарної позиції 4108 або 4109'),
(149, 'ru', 'Вироби з кишок тварин (крім кетгуту з натурального шовку), шлунків, сечових міхурів або сухожиль'),
(150, 'ru', 'Сировина пухо-хутрова (включаючи голови, хвости, лапи та інші обрізки, придатні для використання у виробництві хутрових виробів), крім шкірсировини та шкур товарних позицій 4101, 4102 або 4103'),
(151, 'ru', 'Вовна, не піддана кардо- або гребенечесанню'),
(152, 'ru', 'Тонкий чи грубий волос тварин, не підданий кардо-або гребенечесанню'),
(153, 'ru', 'Шкурки та інші частини птахів, вкриті пір''ям або пухом, частини пір''я, пух та вироби з цих матеріалів (крім виробів товарної позиції 0505 та оброблених стрижнів пір''я)');

INSERT INTO `cargo_type`(`name`, `ukt_zed_code`) VALUES
(36, '0101'),
(37, '0102'),
(38, '0103'),
(39, '0104'),
(40, '0105'),
(41, '010600'),
(42, '0106009010'),
(43, '010609090'),
(44, '0201'),
(45, '0202'),
(46, '0203'),
(47, '0204'),
(48, '020500'),
(49, '0206'),
(50, '0207'),
(51, '0208'),
(52, '020810'),
(53, '0208200000'),
(54, '020890'),
(55, '020900'),
(56, '0210'),
(57, '0301'),
(58, '030110'),
(59, '030191900'),
(60, '0301999000'),
(61, '0302'),
(62, '0302190000'),
(63, '0302691900'),
(64, '0303'),
(65, '0304'),
(66, '0305'),
(67, '0306'),
(68, '030613'),
(69, '030614'),
(70, '030619'),
(71, '030623'),
(72, '030624'),
(73, '030629'),
(74, '0307'),
(75, '030710'),
(76, '0307210000'),
(77, '030731'),
(78, '030739'),
(79, '0307600000'),
(80, '0307991800'),
(81, '0307999000'),
(82, '0401'),
(83, '0402'),
(84, '0403'),
(85, '0404'),
(86, '0405'),
(87, '0406'),
(88, '040700'),
(89, '0408'),
(90, '0409000000'),
(91, '0410000000'),
(92, '0501000000'),
(93, '0502'),
(94, '0503000000'),
(95, '0504000000'),
(96, '0505'),
(97, '0506'),
(98, '0507'),
(99, '0508000000'),
(100, '050900'),
(101, '051000000'),
(102, '0511'),
(103, '1213000000'),
(104, '1214'),
(105, '1403'),
(106, '150100'),
(107, '150200'),
(108, '150300'),
(109, '1504'),
(110, '1505'),
(111, '1506000000'),
(112, '1516'),
(113, '1517'),
(114, '151800'),
(115, '1521'),
(116, '152200'),
(117, '160100'),
(118, '1602'),
(119, '160300'),
(120, '1604'),
(121, '1605'),
(122, '1703'),
(123, '2104'),
(124, '210500'),
(125, '2301'),
(126, '2302'),
(127, '2303'),
(128, '2304000000'),
(129, '2305000000'),
(130, '2306'),
(131, '2308'),
(132, '2309'),
(133, '2309909100'),
(134, '3001'),
(135, '3002'),
(136, '3002905000'),
(137, '3003'),
(138, '300450'),
(139, '3101000000'),
(140, '3501'),
(141, '3502'),
(142, '350300'),
(143, '3504000000'),
(144, '4101'),
(145, '4102'),
(146, '4103'),
(147, '4105'),
(148, '4106'),
(149, '4206'),
(150, '4301'),
(151, '5101'),
(152, '5102'),
(153, '6701000000');

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

INSERT INTO `stringculture`(`id`, `locale`, `value`) VALUES (154, 'ru', 'Администратор'),
                                    (154, 'en', 'Administrator'),
                                    (155, 'ru', 'Лікар вет.медицини'),
                                    (156, 'ru', 'Провідний лікар вет.медицини'),
                                    (157, 'ru', 'Начальник пункта'),
                                    (158, 'ru', 'Начальник віддела'),
                                    (159, 'ru', 'Начальник региональной служби'),
                                    (160, 'ru', 'Перший заступник начальника региональной служби'),
                                    (161, 'ru', 'Заступник начальника региональной служби');

-- job
INSERT INTO `job`(`id`, `name`) VALUES (1,154),(2,155),(3,156),(4,157),(5,158),(6,159),(7,160),(8,161);

-- customs point
INSERT INTO `stringculture`(`id`, `locale`, `value`) VALUES 
(162, 'ru', 'центральна'), (163, 'ru', 'западна'), (164, 'ru', 'східна'), (165, 'ru', 'південна'), (166, 'ru', 'кримська');

INSERT INTO customs_point(`id`, `name`) VALUES
(1, 162), (2, 163), (3, 164), (4, 165), (5, 166);

-- codes of container owners.
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('1','AAAU','','Asia Container Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('2','ACLU','ACL','Atlantic Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('3','ACXU','Atlantic Cargo','Atlantic Cargo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('4','ADCU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('5','AKLU','K Line','Kawasaki Kisen Kaisha, Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('6','ALLU','','Allied Container Network ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('7','ALNU','','ECB Group ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('8','AMCU','CMA CGM','Compagnie Maritime d Affretement Compagnie Generale Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('9','AMFU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('10','AMZU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('11','ANNU','ANL','Australia National Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('12','ANYU','','One Way Lease ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('13','APHU','APL','American President Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('14','APLS','APL','American President Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('15','APLU','APL','American President Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('16','APMU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('17','APRU','APL','American President Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('18','APZU','APL','American President Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('19','ARDU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('20','ARHU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('21','ARMU','','Adeptainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('22','ARTU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('23','ATBU','','A-Tainer & Service ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('24','ATIU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('25','AWSU','Swire','Swire Shipping ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('26','AXIU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('27','AZLU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('28','BAFU','','Bulkhaul Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('29','BBXU','','BestBox-Containerhandel e.K. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('30','BCHU','','Braun Container Handels GmbH ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('31','BGFU','BG Freight','BG Freight Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('32','BHCU','','Bridgehead Container Services Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('33','BLCU','BCL','Baltic Container Lines Co. Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('34','BLKU','','Bulkhaul Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('35','BMLU','Bernuth','Bernuth Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('36','BMOU','','Beacon Intermodal ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('37','BNSU','','BNS Container AS ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('38','BORU','Borchard','Borchard Lines Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('39','BOXU','','Bulkhaul Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('40','BSIU','','Blue Sky Intermodal (UK) Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('41','BVIU','','Stolt Tank Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('42','BXCU','','BoxCon ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('43','CACU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('44','CADU','Hamburg SUD','Hamburg Sudamerikanische Dampfschifffahrts Gesellschaft ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('45','CAIU','','CAI (Container Applications International) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('46','CAPU','','Capital UK Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('47','CARU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('48','CASU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('49','CATU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('50','CAXU','','CAI (Container Applications International) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('51','CBHU','COSCON','COSCO Container Lines Co., Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('52','CCGU','','CATU Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('53','CCLU','CSCL','China Shipping Container Lines Co ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('54','CCRU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('55','CCSU','','Servial CC ApS ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('56','CDKU','','Containerland Danmark ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('57','CESU','','Consent Equipment AB ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('58','CGHU','CMA CGM','Compagnie Maritime d Affretement Compagnie Generale Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('59','CGMU','CMA CGM','Compagnie Maritime d Affretement Compagnie Generale Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('60','CGTU','CMA CGM','Compagnie Maritime d Affretement Compagnie Generale Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('61','CHAU','','Chariot Intermodal Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('62','CHIU','','Capital Intermodal ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('63','CHPU','CHIPOLBROK','Chinese-Polish Joint Stock Shipping Company ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('64','CKLU','CK Line','CK Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('65','CLAU','Conti-Lines','Conti-Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('66','CLDU','','Cobelfret Containers N.V. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('67','CLHU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('68','CLOU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('69','CMAU','CMA CGM','Compagnie Maritime d Affretement Compagnie Generale Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('70','CMBU','Safmarine','Safmarine ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('71','CMCU','','Crowley ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('72','CMNU','CMA CGM','Compagnie Maritime d Affretement Compagnie Generale Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('73','CMTU','','IJ-Container ApS ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('74','CMUU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('75','CNCU','CNC Line','Cheng Lie Navigation Co.,Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('76','CNIU','CCNI','Compagnia Chilena de Navigacion Interoceanica SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('77','CNNU','','China International Container Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('78','CORU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('79','CPIU','','Container Providers International ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('80','CPLU','','ContainerPLUS ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('81','CPSU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('82','CRLU','','Seacastle Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('83','CRSU','','Cronos ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('84','CRTU','','Cronos ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('85','CRXU','','Cronos ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('86','CRYU','','Cryo AB ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('87','CSFU','Containerships','Containerships ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('88','CSLU','CSCL','China Shipping Container Lines Co ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('89','CSOU','Containerships','Containerships ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('90','CSQU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('91','CSVU','CSAV','Compania Sud Americana de Vapores ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('92','CTIU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('93','CTXU','','Containex ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('94','CXCU','Horizon','Horizon Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('95','CZLU','Contaz','Contaz Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('96','CZZU','','CAI (Container Applications International) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('97','DALU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('98','DAYU','DAL','Deutsche Afrika-Linien ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('99','DCSU','','Danish Container Supply A/S ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('100','DFSU','','Dong Fang International Investment Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('101','DLKU','','Stolt Tank Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('102','DNAU','','Unit Equipment Services AG ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('103','DNCU','','DanContainer A/S ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('104','DRYU','','Seacastle Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('105','DVRU','Delmas','Delmas ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('106','EASU','','Waterfront Container Leasing Co. Inc. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('107','ECMU','CMA CGM','Compagnie Maritime d Affretement Compagnie Generale Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('108','ECTU','','Trans European Container Unit ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('109','EGHU','Evergreen','Evergreen Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('110','EIMU','Eimskip','Eimskip ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('111','EISU','Evergreen','Evergreen Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('112','ELOU','MACS','Maritime Carrier Shipping Center GmbH & Co. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('113','EMCU','Evergreen','Evergreen Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('114','ENAU','Hamburg SUD','Hamburg Sudamerikanische Dampfschifffahrts Gesellschaft ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('115','EOLU','','Exim Container Services Pte Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('116','ESFU','FESCO ESF','FESCO ESF ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('117','ESPU','Emirates','Emirates Shipping Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('118','ESSU','K Line','Kawasaki Kisen Kaisha, Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('119','ETNU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('120','EUCU','Eucon','Eucon ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('121','EURU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('122','EUSU','','Unit Equipment Services AG ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('123','EVAU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('124','EXFU','','EXSIF Worldwide, Inc. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('125','EXXU','','EXSIF Worldwide, Inc. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('126','FAAU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('127','FANU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('128','FBIU','','Florens Container Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('129','FBLU','','Florens Container Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('130','FBXU','','Flex-Box Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('131','FCCU','FESCO','Far Eastern Shipping Company ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('132','FCIU','','Florens Container Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('133','FESU','FESCO','Far Eastern Shipping Company ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('134','FFFU','','Florens Container Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('135','FLZU','','Fine Link Container ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('136','FOCU','OPDR','Oldenburg-Portugiesische Dampfschiffs-Rheederei ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('137','FRLU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('138','FSCU','','Florens Container Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('139','FWLU','','Florens Container Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('140','GAEU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('141','GASU','','Bulkhaul Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('142','GATU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('143','GBCU','','Global Container Concepts ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('144','GCCU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('145','GCEU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('146','GCNU','Grimaldi','Grimaldi ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('147','GESU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('148','GETU','Tarros','Tarros S.p.A. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('149','GLDU','','Gold Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('150','GRCU','Borchard','Borchard Lines Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('151','GRDU','','Gold Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('152','GRIU','Hamburg SUD','Hamburg Sudamerikanische Dampfschifffahrts Gesellschaft ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('153','GSLU','GSL','Gold Star Line Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('154','GSTU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('155','GVCU','','UES International (HK) Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('156','GVDU','','UES International (HK) Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('157','GVTU','','Grand View Container Trading ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('158','HALU','Heung-A','Heung-A Shipping Co., Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('159','HAMU','HMM','Hyundai Merchant Marine Co., Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('160','HBSU','','HANBAO Container Shipping & Trading ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('161','HCIU','','Capital Intermodal ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('162','HDLU','Safmarine','Safmarine ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('163','HDMU','HMM','Hyundai Merchant Marine Co., Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('164','HFAU','','Bulkhaul Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('165','HJCU','Hanjin','Hanjin Shipping Co. Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('166','HLCU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('167','HLXU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('168','HMCU','Evergreen','Evergreen Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('169','HMKU','WEC','West European Container Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('170','HMMU','HMM','Hyundai Merchant Marine Co., Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('171','HRZU','Horizon','Horizon Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('172','IBTU','','InterBulk Group ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('173','ICCU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('174','ICHU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('175','ICOU','','ICON International Container Service ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('176','ICSU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('177','ICUU','ICL','Independent Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('178','IEAU','','Cronos ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('179','IJCU','','IJ-Container ApS ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('180','IKKU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('181','IKSU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('182','IMDU','','Seateq Corp. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('183','IMNU','','Seateq Corp. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('184','IMTU','Evergreen','Evergreen Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('185','INBU','','Seacastle Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('186','INGU','','Trifleet Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('187','INKU','','Seacastle Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('188','INNU','','Seacastle Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('189','IPXU','','Seacastle Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('190','IRNU','','Seacastle Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('191','IRSU','HDS Lines','Hafiz Darya Shipping Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('192','ITAU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('193','ITLU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('194','IVLU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('195','IXWU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('196','JSCU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('197','JSSU','CNCo','The China Navigation Co.,Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('198','KHJU','Hamburg SUD','Hamburg Sudamerikanische Dampfschifffahrts Gesellschaft ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('199','KHLU','Hamburg SUD','Hamburg Sudamerikanische Dampfschifffahrts Gesellschaft ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('200','KKFU','K Line','Kawasaki Kisen Kaisha, Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('201','KKTU','K Line','Kawasaki Kisen Kaisha, Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('202','KLCU','Containerships','Containerships ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('203','KLFU','K Line','Kawasaki Kisen Kaisha, Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('204','KLTU','K Line','Kawasaki Kisen Kaisha, Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('205','KMSU','YML','Yang Ming Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('206','KMTU','KMTC','Korea Marine Transport Co., Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('207','KNLU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('208','KWCU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('209','LANU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('210','LBIU','Libra','Companhia Libra de Navegacao ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('211','LCRU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('212','LGEU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('213','LMCU','Linea Messina','Linea Messina ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('214','LNXU','CSAV','Compania Sud Americana de Vapores ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('215','LOGU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('216','LPIU','','Cronos ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('217','LSEU','','One Way Lease ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('218','LTIU','Evergreen','Evergreen Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('219','LVNU','','Flex-Box Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('220','LVTU','POL-LEVANT','POL-LEVANT Shipping Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('221','LYTU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('222','MAEU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('223','MAGU','','Magellan Maritime Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('224','MAJU','MISC','Malaysia International Shipping Corporation Berhad ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('225','MANU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('226','MARU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('227','MATU','Matson','Matson ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('228','MAXU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('229','MBIU','','Bridgehead Container Services Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('230','MCLU','Borchard','Borchard Lines Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('231','MEAU','','Star Container Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('232','MEDU','MSC','Mediterranean Shipping Company ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('233','MFRU','Marfret','Marfret Compagnie Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('234','MFTU','Marfret','Marfret Compagnie Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('235','MGBU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('236','MGLU','','Magellan Maritime Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('237','MGNU','','Seacastle Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('238','MHCU','MAG','MAG Shipping Company ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('239','MHHU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('240','MIEU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('241','MISU','MISC','Malaysia International Shipping Corporation Berhad ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('242','MLCU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('243','MMCU','CMA CGM','Compagnie Maritime d Affretement Compagnie Generale Maritime ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('244','MMPU','MSCO','Murmansk Shipping Company ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('245','MNLU','MISC','Malaysia International Shipping Corporation Berhad ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('246','MOAU','MOL','Mitsui O.S.K. Lines (O.S.K. Osaka Shosen Kaisha) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('247','MOCU','MACS','Maritime Carrier Shipping Center GmbH & Co. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('248','MOEU','MOL','Mitsui O.S.K. Lines (O.S.K. Osaka Shosen Kaisha) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('249','MOFU','MOL','Mitsui O.S.K. Lines (O.S.K. Osaka Shosen Kaisha) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('250','MOGU','MOL','Mitsui O.S.K. Lines (O.S.K. Osaka Shosen Kaisha) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('251','MOLU','MOL','Mitsui O.S.K. Lines (O.S.K. Osaka Shosen Kaisha) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('252','MOMU','Libra','Companhia Libra de Navegacao ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('253','MORU','MOL','Mitsui O.S.K. Lines (O.S.K. Osaka Shosen Kaisha) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('254','MOSU','MOL','Mitsui O.S.K. Lines (O.S.K. Osaka Shosen Kaisha) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('255','MOTU','MOL','Mitsui O.S.K. Lines (O.S.K. Osaka Shosen Kaisha) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('256','MRKU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('257','MSCU','MSC','Mediterranean Shipping Company ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('258','MSFU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('259','MSHU','MISC','Malaysia International Shipping Corporation Berhad ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('260','MSKU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('261','MSUU','','M/S Container A/S ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('262','MSWU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('263','MVIU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('264','MWCU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('265','MWMU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('266','MWSU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('267','NCCU','','Nippon Concept Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('268','NCXU','Nor Lines','Nor Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('269','NDLU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('270','NEPU','APL','American President Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('271','NEVU','','Consent Equipment AB ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('272','NIRU','Nirint Shipping','Nirint Shipping ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('273','NODU','Nordana','Nordana Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('274','NOLU','APL','American President Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('275','NOSU','APL','American President Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('276','NPRU','SSL','Sea Star Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('277','NSAU','NSCSA','National Shipping Company of Saudi Arabia ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('278','NSLU','CSAV Norasia','CSAV Norasia ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('279','NSRU','Namsung','Namsung Shipping Co., Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('280','NSSU','Namsung','Namsung Shipping Co., Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('281','NYKU','NYK Line','Nippon Yusen Kabushiki Kaisha Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('282','NYNU','NYK Line','Nippon Yusen Kabushiki Kaisha Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('283','OCLU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('284','OKCU','CSS','Cahaya Samudera Shipping Pte Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('285','OOLU','OOCL','Orient Overseas Container Line Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('286','OPCU','OPDR','Oldenburg-Portugiesische Dampfschiffs-Rheederei ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('287','OPDU','OPDR','Oldenburg-Portugiesische Dampfschiffs-Rheederei ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('288','OTAU','OTAL','OT Africa Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('289','OTEU','','Consent Equipment AB ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('290','PCIU','PIL','Pacific International Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('291','PCVU','','Peacock ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('292','PDLU','PDL','Pacific Direct Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('293','PERU','Safmarine','Safmarine ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('294','PFLU','PFL','Pacific Forum Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('295','PGRU','','C& Container Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('296','POCU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('297','PONU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('298','PRGU','','Progeco ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('299','PRSU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('300','PRTU','Portline','Portline ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('301','PSSU','','Pentalver Transport ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('302','QIBU','UASC','United Arab Shipping Company Co.(S.A.G) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('303','QNLU','UASC','United Arab Shipping Company Co.(S.A.G) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('304','QNNU','UASC','United Arab Shipping Company Co.(S.A.G) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('305','RALU','RAL','Royal Arctic Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('306','RAVU','','Flex-Box Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('307','REGU','RCL','Regional Container Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('308','RILU','Rickmers Line','Rickmers Linie ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('309','RMCU','','Multistar ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('310','SACU','WWL','Wallenius Wilhelmsen Logistics ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('311','SAMU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('312','SANU','Samskip','Samskip ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('313','SBAU','','Seibow Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('314','SBGU','SSL','Sea Star Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('315','SBLU','Baco-Liner','Seereederei Baco-Liner GmbH ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('316','SCCU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('317','SCIU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('318','SCMU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('319','SCPU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('320','SCSU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('321','SCXU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('322','SCZU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('323','SEAU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('324','SENU','Hanjin','Hanjin Shipping Co. Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('325','SESU','','Spinnaker Equipment Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('326','SGCU','','Overcont Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('327','SIIU','SCI','The Shipping Coporation of India Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('328','SIKU','Samudera','Samudera Shipping Line Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('329','SITU','SITC','SITC Container Lines Co., LTD ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('330','SIUU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('331','SKLU','Sinokor','Sinokor Merchant Marine Co.,Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('332','SKRU','Sinokor','Sinokor Merchant Marine Co.,Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('333','SKYU','','CAI (Container Applications International) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('334','SLCU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('335','SLMU','','Gold Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('336','SLSU','','Spinnaker Equipment Services ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('337','SMLU','Seaboard Marine','Seaboard Marine ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('338','SNBU','Sinolines','Sinotrans Container Lines Co.,Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('339','SNGU','Sinolines','Sinotrans Container Lines Co.,Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('340','SNHU','Sinolines','Sinotrans Container Lines Co.,Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('341','SNIU','','Stolt Tank Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('342','SNTU','','Stolt Tank Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('343','SOCU','','Star Service ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('344','SPLU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('345','SPWU','','SpaceWise ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('346','SSIU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('347','STMU','Delmas','Delmas ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('348','STRU','SSL','Sea Star Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('349','SUDU','Hamburg SUD','Hamburg Sudamerikanische Dampfschifffahrts Gesellschaft ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('350','SVWU','','CHS Container ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('351','SWTU','','Stolt Tank Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('352','TABU','','Stolt Tank Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('353','TAIU','','Stolt Tank Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('354','TASU','','Tankspan ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('355','TCIU','','TITAN Containers International A/S ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('356','TCKU','','Triton Container International Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('357','TCLU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('358','TCNU','','Triton Container International Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('359','TEHU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('360','TEXU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('361','TGHU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('362','TIFU','','Trifleet Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('363','TISU','','TIS (Transport Industrial Service) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('364','TITU','','TITAN Containers International A/S ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('365','TLCU','Tschudi','Tschudi Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('366','TLNU','','Trident Container Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('367','TLXU','TA','Trans Asia Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('368','TMIU','','Trifleet Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('369','TMMU','Hapag','Hapag Lloyd Container Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('370','TMYU','Transinsular','Transportes Maritimos Insulares, S.A. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('371','TOLU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('372','TOPU','','TOPtainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('373','TORU','Maersk Line','Maersk Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('374','TPCU','WHL','Wan Hai Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('375','TPHU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('376','TPMU','','EXSIF Worldwide, Inc. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('377','TPTU','','EXSIF Worldwide, Inc. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('378','TPXU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('379','TQMU','','Intermodal Tank Transport ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('380','TRDU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('381','TRIU','','Triton Container International Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('382','TRKU','Turkon','Turkon Line Inc ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('383','TRLU','','TAL International Container Corporation ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('384','TRTU','','Caru ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('385','TTNU','','Triton Container International Limited ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('386','TTTU','','Eurotainer SA ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('387','UACU','UASC','United Arab Shipping Company Co.(S.A.G) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('388','UAEU','UASC','United Arab Shipping Company Co.(S.A.G) ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('389','UESU','','Unit Equipment Services AG ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('390','UETU','','UES International (HK) Ltd. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('391','UFCU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('392','UGMU','Evergreen','Evergreen Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('393','UNIU','','Unitas Container Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('394','UNOU','','Uniteam Norway ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('395','UNXU','','Unitas Container Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('396','USPU','','EXSIF Worldwide, Inc. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('397','UTCU','','Stolt Tank Containers ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('398','UTTU','','InterBulk Group ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('399','UXXU','','Unit Equipment Services AG ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('400','VNLU','VINALines','Vietnam National Shipping Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('401','WCIU','','Textainer ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('402','WECU','WEC','West European Container Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('403','WFHU','','Waterfront Container Leasing Co. Inc. ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('404','WHLU','WHL','Wan Hai Lines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('405','WLNU','WWL','Wallenius Wilhelmsen Logistics ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('406','WWLU','WWL','Wallenius Wilhelmsen Logistics ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('407','WWWU','','Wind Container Leasing ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('408','XINU','','Xines ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('409','XTRU','','GE SeaCo ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('410','YMLU','YML','Yang Ming Line ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('411','ZCSU','ZIM','ZIM Integrated Shipping Services Ltd ');
INSERT INTO `container_validator` (`id`, `prefix`, `carrier_abbr`, `carrier_name`) VALUES('412','ZIMU','ZIM','ZIM Integrated Shipping Services Ltd');

UPDATE `generator` SET `generatorValue` = 166 WHERE `generatorName` = 'books';

/* reports */
INSERT INTO `reports`(`id`) VALUES ('MOVEMENT_TYPES_REPORT'), ('CARGOS_IN_DAY_REPORT'), ('REGIONAL_CONTROL_REPORT'), ('ARREST_REPORT'),
('EXTENDED_ARREST_REPORT'), ('MEAT_IN_DAY_REPORT'), ('MEAT_IN_YEAR_REPORT');

