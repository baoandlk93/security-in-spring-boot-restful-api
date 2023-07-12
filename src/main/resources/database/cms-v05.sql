use `demo_security`;

create table if not exists roles (
    id int not null auto_increment primary key,
    name varchar(50) not null,
    description varchar(50) not null
);

insert into roles (name, description) values
('ROLE_ADMIN', 'Quản trị viên'),
('ROLE_EMPLOYEE', 'Nhân viên'),
('ROLE_CUSTOMER', 'Khách hàng')
;

create table if not exists users (
     id int not null auto_increment primary key ,
     fullname varchar(100) not null,
     username varchar(100) not null unique,
     password varchar(200) not null,
     email varchar(100) not null unique ,
     address varchar(200)  null,
     phone varchar(12)  null,
     avatar varchar(200)  null,
     activated bit(1) default 1 not null,
     remember_token varchar(200)
);

insert into users (fullname, username, password, email, address, phone, avatar, activated, remember_token) values
('Nguyễn Bá Minh Đạo', 'daonguyenadmin', '$2a$10$oztyYOzexbKMwNQi.xfE4uOVjKByoNiuAHKO9zL83LMA0czAXtP3.', 'daonguyen.admin@gmail.com',
 'Hồ Chí Minh', '0908983906', 'avatar1.png', true, 'rAPHFeXDlQCjenQ6nffqe56hC9EulnyQTDKGzhuKjCIrVI4Cy0hWGEtsvJdA') -- password: 123456
,('Nguyễn Văn Tý', 'tynguyenuser', '$2a$10$oztyYOzexbKMwNQi.xfE4uOVjKByoNiuAHKO9zL83LMA0czAXtP3.', 'tynguyen.user@gmail.com',
'Hồ Chí Minh', '0985678910', 'avatar1.jpg', true, 'sDh9x4HXrBCOJzgBH5qeZwcjVgN8Uv4u1WZBVQsYbp0moh7eDG260xJe07dF') -- password: 123456
,( 'Nguyễn Văn Tèo', 'teonguyenuser', '$2a$10$oztyYOzexbKMwNQi.xfE4uOVjKByoNiuAHKO9zL83LMA0czAXtP3.', 'teonguyen.user@gmail.com',
'Hồ Chí Minh', '0981234567', 'avatar1.jpg', true, '2iV7Lpa1sgCafdEOkbh2wVeYKamoc7kAb0CF6kAQJSVymts7g1uHZO9iUMI7') -- password: 123456
;

create table if not exists users_roles (
    id int primary key not null auto_increment,
    user_id int not null,
    role_id int not null,
    constraint users_roles_roles_fk foreign key (role_id) references roles (id),
    constraint users_roles_users_fk foreign key (user_id) references users (id)
);

insert into users_roles (user_id, role_id) values
(1, 1)
,(1, 2)
,(1, 3)
,(2, 2)
,(3, 3)
;