-- USERS

insert into users (id, email, name, password, decline_reason, reward_point, role_type)
values (111, 'test@test.com', 'sayal adhikari', '$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2', 'no reason', 100, 'ADMIN'); -- 123

insert into users (id, email, name, password, decline_reason, reward_point, role_type)
values (222, 'smaka@miu.edu', 'sujan', '$2a$10$7maL108rRqx01Q3qY5ee6e6E8G1t/u873fLUSrKfTzibNiFJp86sW', 'no reason', 100, 'ADMIN'); -- 123

insert into users (id, email, name, password, decline_reason, reward_point, role_type)
values (333, 'seller@test.com', 'sayal adhikari', '$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2', 'no reason', 100, 'SELLER'); -- 123

-- ROLES
insert into role (id, role_type)
values (1, 'ADMIN');
insert into role (id, role_type)
values (2, 'BUYER');
insert into role (id, role_type)
values (3, 'SELLER');


insert into users_roles (user_id, roles_id)
values (111, 1);
insert into users_roles (user_id, roles_id)
values (222, 1);
insert into users_roles (user_id, roles_id)
values (111, 2);
insert into users_roles (user_id, roles_id)
values (111, 3);
insert into users_roles (user_id, roles_id)
values (333, 3);

/* Sellers */
insert into users (id, created_date, modified_date, status, user_id, decline_reason, email, name, password,
                   reward_point, role_type)
values (100,'2022-03-22 22:06:21.777852','2022-04-19 02:28:21.777852','APPROVED','mydream@miu.edu','','lala@hotmail.com','La La Dream','$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2',0,'SELLER');
insert into users (id, created_date, modified_date, status, user_id, decline_reason, email, name, password,
                   reward_point, role_type)
values (200,'2022-04-19 09:30:21.777852','2022-04-19 02:28:21.777852','CREATED','sulai@miu.edu','','verizon@gmail.com','Seller Verizon','$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2',0,'SELLER');

insert into users (id, created_date, modified_date, status, user_id, decline_reason, email, name, password,
                   reward_point, role_type)
values (300,'2022-02-11 08:30:21.777852','2022-04-19 02:28:21.777852','CREATED','diamond@miu.edu','','football@gmail.com','Diamond Online','$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2',0,'SELLER');

insert into users (id, created_date, modified_date, status, user_id, decline_reason, email, name, password,
                   reward_point, role_type)
values (400,'2022-01-21 00:30:21.777852','2022-04-19 02:28:21.777852','CREATED','jsmith@miu.edu','','smtth789@gmail.com','Jone Smith','$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2',0,'SELLER');

insert into users (id, created_date, modified_date, status, user_id, decline_reason, email, name, password,
                   reward_point, role_type)
values (500,'2022-03-03 02:45:21.777852','2022-04-19 02:28:21.777852','CREATED','bibb@miu.edu','','micheal@gmail.com','Micheal biber','$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2',0,'SELLER');

/* Buyers */
insert into users (id, created_date, modified_date, status, user_id, decline_reason, email, name, password,
                   reward_point, role_type)
values (600,'2022-03-03 02:45:21.777852','2022-04-19 02:28:21.777852','APPROVED','buyer@miu.edu','','buyer-mike@gmail.com','Buyer Micheal','$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2', 50,'BUYER');

insert into users (id, created_date, modified_date, status, user_id, decline_reason, email, name, password,
                   reward_point, role_type)
values (700,'2022-03-03 11:45:21.777852','2022-04-19 02:28:21.777852','APPROVED','buyer-henery@miu.edu','','buyer-hh@gmail.com','Buyer Henery','$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2',550,'BUYER');

insert into users (id, created_date, modified_date, status, user_id, decline_reason, email, name, password,
                   reward_point, role_type)
values (800,'2022-04-22 01:30:21.777352','2022-04-19 02:28:21.777852','CREATED','mel101@miu.edu','','melisa@gmail.com','Mellisa Presley','$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2',0,'SELLER');


/*************************/
/*Product*/
insert into product (id, created_date, modified_date, status, user_id, category, cost, description, name, picture,
                     product_index, quantity, rating, tags)
values (13232,'2022-04-19 20:16:51.379000','2022-04-19 20:16:51.379000','CREATED','test@test.com','','1450','New innovation of smart phone vs tablet feature combination','Samsung S22 Ultra Silver White Platinum','https://images.samsung.com/is/image/samsung/p6pim/levant/2202/gallery/levant-galaxy-s22-plus-s906-412889-sm-s906eidgmea-530961108','',10,'','');

insert into product (id, created_date, modified_date, status, user_id, category, cost, description, name, picture,
                     product_index, quantity, rating, tags)
values (22423,'2022-04-19 20:16:51.379000','2022-04-19 20:16:51.379000','CREATED','test@test.com','','1450','10.9-inch Liquid Retina display with True Tone, P3 wide color, and an antireflective coating','2022 Apple iPad Air (10.9-inch, Wi-Fi, 256GB) - Blue (5th Generation)','https://m.media-amazon.com/images/I/71FePRgkiZL._AC_SX425_.jpg','',10,'','');

insert into product (id, created_date, modified_date, status, user_id, category, cost, description, name, picture,
                     product_index, quantity, rating, tags)
values (35052,'2022-04-19 20:16:51.379000','2022-04-19 20:16:51.379000','CREATED','test@test.com','','1450','WITH ELDERBERRY, AND FOUR KEY IMMUNE SUPPORT NUTRIENTS: ','Elderberry fruit extract, Vitamin C, Vitamin E, Zinc, and Melatonin, 40 Gummies','https://d124ep1ou7ef1k.cloudfront.net/wp-content/uploads/2022/03/Galaxy_A53_5G_MA_Thumb.jpg','',10,'','');

/*Review */

insert into review (id, created_date, modified_date, status, user_id, content, title, product_id)
values (1000, '2022-04-19 20:16:51.379000','2022-04-19 20:16:51.379000','CREATED', 'test@test.com','Dear Samsung, you need to add, not remove useful features on your flagship phones. Samsung was mocking Apple for removing a 3.5mm headphone jack on their phones in their commercials and then did the same thing', 'NO 3.5MM HEADPHONE JACK. NO Micro SD CARD. NOT WORTH THE UPGRADE',13232);

insert into review (id, created_date, modified_date, status, user_id, content, title, product_id)
values (2000, '2022-04-19 11:16:51.379000','2022-04-19 20:16:51.379000','CREATED', 'buyer-mike@gmail.com','I love this new Ipad air. Like other viewers I switched from purple to blue as the purple color is barely there.
The blue is an awesome color and the accompanying case from apple is also gorgeous.
M1 chip is fast, promotion would be better.', 'Terrific Apple Product and Well Made!',22423);

insert into review (id, created_date, modified_date, status, user_id, content, title, product_id)
values (3000, '2022-04-19 06:16:51.379000','2022-04-19 20:16:51.379000','CREATED', 'buyer-hh@gmail.com','I was super scared but it was very much worth it and it came in much faster than regular apple and it came 2 days early. The Purple is so pretty.', 'Very glad I bought this iPad, I love it',22423);

insert into review (id, created_date, modified_date, status, user_id, content, title, product_id)
values (4000, '2022-04-19 12:16:51.379000','2022-04-19 20:16:51.379000','CREATED', 'buyer-hh@gmail.com','The taste on these supplements isn''t terrible but it isn''t delicious either. There are no artificial flavors or high fructose corn syrup so I feel like that''s why it has the taste that it has', 'I sleep well and have dreams with these.',35052);

insert into review (id, created_date, modified_date, status, user_id, content, title, product_id)
values (5000, '2022-04-19 04:16:51.379000','2022-04-19 20:16:51.379000','CREATED', 'buyer-mike@gmail.com','I’ve tried so many Melatonin Gummies to help with sleep and these gummies are beyond great. The texture is smooth and tastes so great. Highly recommend this product to help with sleep. Remember to use as recommended and keep out of reach children.', 'Must have',35052);


