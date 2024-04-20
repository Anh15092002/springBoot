-- Bảng category lưu thông tin về các danh mục mặt hàng
CREATE TABLE Category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Bảng goods lưu thông tin về các mặt hàng bán trong cửa hàng
CREATE TABLE Goods (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    stock_quantity INTEGER NOT NULL,
    description TEXT,
    image_url TEXT,
    category_id INTEGER REFERENCES category(id)
);

-- Bảng member lưu thông tin về các thành viên của cửa hàng (khách hàng)
CREATE TABLE Member (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    city VARCHAR(50),
    country VARCHAR(50)
);

-- Bảng order lưu thông tin về các đơn hàng
CREATE TABLE Orders (
    id SERIAL PRIMARY KEY,
    member_id INTEGER REFERENCES member(id),
    order_date DATE NOT NULL DEFAULT CURRENT_DATE,
    total_amount NUMERIC(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    shipping_address TEXT,
    shipping_method VARCHAR(100)
);

-- Bảng order_detail lưu chi tiết các mặt hàng trong đơn hàng
CREATE TABLE Order_detail (
    id SERIAL PRIMARY KEY,
    order_id INTEGER REFERENCES Orders(id),
    goods_id INTEGER REFERENCES goods(id),
    quantity INTEGER NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    discount NUMERIC(5, 2)
);

-- Bảng coupon lưu thông tin về các mã giảm giá
CREATE TABLE Coupon (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    discount NUMERIC(5, 2) NOT NULL,
    expiration_date DATE
);

-- Bảng delivery lưu thông tin về các phương thức giao hàng
CREATE TABLE Delivery (
    id SERIAL PRIMARY KEY,
    method VARCHAR(100) NOT NULL,
    delivery_time INTEGER
);


-- Insert dummy data cho bảng category
INSERT INTO Category (name) VALUES 
('Sneakers'),
('Boots'),
('Sandals'),
('Loafers');

-- Insert dummy data cho bảng goods
INSERT INTO Goods (name, price, stock_quantity, description, image_url, category_id) VALUES 
('Nike Air Max', 150.00, 50, 'Giày thể thao thoải mái và phong cách', 'https://example.com/nike-air-max.jpg', 1),
('Timberland Waterproof Boots', 200.00, 30, 'Giày bền cho các hoạt động ngoài trời', 'https://example.com/timberland-boots.jpg', 2),
('Adidas Adilette Slides', 30.00, 70, 'Giày sandal thông thường và nhẹ', 'https://example.com/adidas-slides.jpg', 3),
('Sperry Top-Sider Boat Shoes', 80.00, 40, 'Giày lười cổ điển và thoải mái để mặc hàng ngày', 'https://example.com/sperry-loafers.jpg', 4);

-- Insert dummy data cho bảng member
INSERT INTO Member (name, password, email, phone, address, city, country) VALUES
('Tuấn Anh', '123456', 'tuananh0220@gmail.com', '123456789', 'Ban Giang', 'Vinh Phuc', 'VIETNAM'),
('Hoàng Hải', '456789', 'hoanghai@gmail.com', '987654321', 'Hoai Duc', 'Ha Noi', 'VIETNAM');

-- Insert dummy data cho bảng order
INSERT INTO Orders (member_id, order_date, total_amount, status, shipping_address, shipping_method) VALUES
(1, '2024-04-10', 280.00, 'Shipped', 'Ban Giang, Vinh Phuc, VIETNAM', 'Standard Shipping'),
(2, '2024-04-11', 120.00, 'Processing', 'Hoai Duc, Ha Noi, VIETNAM', 'Express Shipping');

-- Insert dummy data cho bảng order_detail
INSERT INTO Order_detail (order_id, goods_id, quantity, price, discount) VALUES
(1, 1, 1, 150.00, NULL),
(1, 3, 2, 60.00, 5.00),
(2, 4, 1, 80.00, NULL);

-- Insert dummy data into coupon table
INSERT INTO Coupon (code, discount, expiration_date) VALUES
('SPRINGSALE', 10.00, '2024-04-30'),
('SUMMERSALE', 15.00, '2024-06-30');

-- Insert dummy data into delivery table
INSERT INTO Delivery (method, delivery_time) VALUES
('Standard Shipping', 5),
('Express Shipping', 2);


--Tổng hợp số lượng mặt hàng user mua trong tháng:
SELECT Goods.name, SUM(Order_detail.quantity) AS total_quantity
FROM Goods
INNER JOIN Order_detail ON Goods.id = Order_detail.goods_id
INNER JOIN Orders ON Order_detail.order_id = Orders.id
WHERE EXTRACT(MONTH FROM Orders.order_date) = EXTRACT(MONTH FROM CURRENT_DATE)
GROUP BY Goods.name;

--Tổng hợp doanh thu của cửa hàng trong tháng:
SELECT SUM(Order_detail.quantity * Order_detail.price) AS total_revenue
FROM Order_detail
INNER JOIN Orders ON Order_detail.order_id = Orders.id
WHERE EXTRACT(MONTH FROM Orders.order_date) = EXTRACT(MONTH FROM CURRENT_DATE);
