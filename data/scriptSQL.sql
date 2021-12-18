--  select * from BangChamCong   delete from BangChamCong
create database qllsp;
go
use qllsp;
--BangChamCong table
create table BangChamCong(
	maCongNhan varchar(255),
	tenCongNhan nvarchar(255),
	maSanPham varchar(255),
	soLuong int,
	donGia float,
	ngayChamCong DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	maPhanXuong varchar(255)
);
insert into BangChamCong values ('CN1',N'Nguyễn Văn A','SP1',10,25000,'2020-12-05 15:06:25.347','PX1');
insert into BangChamCong values ('CN2',N'Nguyễn Văn A2','SP2',10,24000,'2020-12-05 15:06:25.348','PX1');
insert into BangChamCong values ('CN3',N'Nguyễn Văn A3','SP3',10,23000,'2020-12-05 15:06:25.349','PX1');
insert into BangChamCong values ('CN4',N'Nguyễn Văn A4','SP4',10,22000,'2020-12-05 15:06:25.350','PX1');
insert into BangChamCong values ('CN5',N'Nguyễn Văn A5','SP5',10,21000,'2020-12-05 15:06:25.351','PX1');
insert into BangChamCong values ('CN6',N'Nguyễn Văn A6','SP6',10,20000,'2020-12-05 15:06:25.352','PX1');
insert into BangChamCong values ('CN7',N'Nguyễn Văn A7','SP7',10,19000,'2020-12-05 15:06:25.353','PX1');
insert into BangChamCong values ('CN8',N'Nguyễn Văn A8','SP8',10,18000,'2020-12-05 15:06:25.354','PX1');
insert into BangChamCong values ('CN9',N'Nguyễn Văn A9','SP9',10,17000,'2020-12-05 15:06:25.355','PX1');
insert into BangChamCong values ('CN10',N'Nguyễn Văn A10','SP10',10,16000,'2020-12-05 15:06:25.356','PX1');
--DanhSachBangChamCong select sum(soLuong),sum(soLuong*donGia) from BangChamCong where maCongNhan = 'CN4';
create table DanhSachBangChamCong(
	maBangChamCong varchar(255) PRIMARY KEY,
	maPhanXuong varchar(255),
	nghiepVu nvarchar(255),
	viTri nvarchar(255),
	soLuongCongNhan int,
	nguoiDaiDien nvarchar(255),
	ngayChamCong DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP UNIQUE,

	stt int,
);
insert into DanhSachBangChamCong values ('BCC1','PX1',N'Nhập nguyên liệu','A0.1',30,N'Nguyễn Văn A','2021-12-01 14:57:34.207',1);
--SanPham table (singleton)
create table SanPham(
    maSanPham varchar(255) PRIMARY KEY,
    tenSanPham NVARCHAR(255),
    soLuong int,
    donGia float,
	donVi nvarchar(255),

	stt int
);
insert into SanPham values ('SP1',N'Áo A',50,20000,N'Chiếc',1);
insert into SanPham values ('SP2',N'Áo B',50,20000,N'Chiếc',2);
insert into SanPham values ('SP3',N'Áo C',50,20000,N'Chiếc',3);
insert into SanPham values ('SP4',N'Áo D',50,20000,N'Chiếc',4);
insert into SanPham values ('SP5',N'Áo E',50,20000,N'Chiếc',5);
insert into SanPham values ('SP6',N'Áo F',50,20000,N'Chiếc',6);
insert into SanPham values ('SP7',N'Áo G',50,20000,N'Chiếc',7);
insert into SanPham values ('SP8',N'Áo H',50,20000,N'Chiếc',8);
insert into SanPham values ('SP9',N'Áo I',50,20000,N'Chiếc',9);
insert into SanPham values ('SP10',N'Áo J',50,20000,N'Chiếc',10);
--CongDoan table
create table CongDoan(
	maCongDoan varchar(255) PRIMARY KEY,
	tenCongDoan NVARCHAR(255),
	thoiGianHoatDong VARCHAR(255),
	stt int,

	maSanPham varchar(255) foreign key references SanPham(maSanPham)
);
insert into CongDoan values ('CD1',N'Chuẩn bị nguyên liệu','CA 1, CA 2',1,'SP1');
insert into CongDoan values ('CD2',N'Tạo mẫu rập khuôn, sơ đồ','CA 1, CA 2',2,'SP2');
insert into CongDoan values ('CD3',N'Trải và cắt vải','CA 1, CA 2',3,'SP3');
insert into CongDoan values ('CD4',N'Chuyển đến xưởng may','CA 1, CA 2',4,'SP4');
insert into CongDoan values ('CD5',N'May thành phẩm','CA 1, CA 2',5,'SP5');
insert into CongDoan values ('CD6',N'Cắt chỉ thừa','CA 1, CA 2',6,'SP6');
insert into CongDoan values ('CD7',N'In logo, trang trí','CA 1, CA 2',7,'SP7');
insert into CongDoan values ('CD8',N'Ủi lại tạo phẳng','CA 1, CA 2',8,'SP8');
insert into CongDoan values ('CD9',N'Đóng gói SP','CA 1, CA 2',9,'SP9');
insert into CongDoan values ('CD10',N'Chất hàng lên xe VC','CA 1, CA 2',10,'SP10');
--PhanXuong table select * from phanxuong select * from danhsachbangchamcong select * from bangchamcong
create table PhanXuong(
	maPhanXuong varchar(255) PRIMARY KEY,
	nghiepVu nvarchar(255),
	nguoiDaiDien nvarchar(255),
	viTri nvarchar(255),
	soLuongCongNhan int,
	soLuongMayMoc int,
	stt int,

	maCongDoan varchar(255) foreign key references CongDoan(maCongDoan)
);
insert into PhanXuong values ('PX1',N'Nhập nguyên liệu',N'Nguyễn Văn A','A0.1',30,50,1,'CD1');
insert into PhanXuong values ('PX2',N'Tạo khuôn mẫu 3D',N'Nguyễn Văn B','A0.2',31,49,2,'CD2');
insert into PhanXuong values ('PX3',N'Cắt vải theo khuôn',N'Nguyễn Văn C','A0.3',32,48,3,'CD3');
insert into PhanXuong values ('PX4',N'Chuyển vải, cắt chỉ thừa',N'Nguyễn Văn D','A0.4',33,47,4,'CD4');
insert into PhanXuong values ('PX5',N'May áo',N'Nguyễn Văn E','A0.5',34,46,5,'CD5');
insert into PhanXuong values ('PX6',N'May logo, hoa văn',N'Nguyễn Văn F','A0.6',35,45,6,'CD6');
insert into PhanXuong values ('PX7',N'Cắt chỉ thừa áo may',N'Nguyễn Văn G','A0.7',36,44,7,'CD7');
insert into PhanXuong values ('PX8',N'Ủi lại toàn bộ',N'Nguyễn Văn H','A0.8',37,43,8,'CD8');
insert into PhanXuong values ('PX9',N'Đóng gói package',N'Nguyễn Văn I','A0.9',38,42,9,'CD9');
insert into PhanXuong values ('PX10',N'Chuyển hàng lên xe',N'Nguyễn Văn J','B1.0',39,41,10,'CD10');
--CongNhan table
create table CongNhan(
	maCongNhan varchar(255) PRIMARY KEY,
	tenCongNhan NVARCHAR(255),
	namSinh int,
	gioiTinh nvarchar(255),
	ngayKhoiCong date,
	SDT varchar(255),
	stt int,

	maPhanXuong varchar(255) foreign key references PhanXuong(maPhanXuong)
);
insert into CongNhan values ('CN1',N'Nguyễn Văn A',1999,'Nam','2019-05-03','0338188500',1,'PX1');
insert into CongNhan values ('CN2',N'Nguyễn Văn B',1998,'Nam','2019-05-03','0338188501',2,'PX2');
insert into CongNhan values ('CN3',N'Nguyễn Văn C',1997,'Nam','2019-05-03','0338188502',3,'PX3');
insert into CongNhan values ('CN4',N'Nguyễn Văn D',1996,'Nam','2019-05-03','0338188503',4,'PX4');
insert into CongNhan values ('CN5',N'Nguyễn Văn E',1995,'Nam','2019-05-03','0338188504',5,'PX5');
insert into CongNhan values ('CN6',N'Nguyễn Văn F',1994,'Nam','2019-05-03','0338188505',6,'PX6');
insert into CongNhan values ('CN7',N'Nguyễn Văn G',1993,'Nam','2019-05-03','0338188506',7,'PX7');
insert into CongNhan values ('CN8',N'Nguyễn Văn H',1992,'Nam','2019-05-03','0338188507',8,'PX8');
insert into CongNhan values ('CN9',N'Nguyễn Văn I',1991,'Nam','2019-05-03','0338188508',9,'PX9');
insert into CongNhan values ('CN10',N'Nguyễn Văn J',1990,'Nam','2019-05-03','0338188509',10,'PX10');
--PhongBan table
create table PhongBan(
	maPhongBan varchar(255) PRIMARY KEY,
	nghiepVu nvarchar(255),
	nguoiDaiDien nvarchar(255),
	viTri nvarchar(255),
	soLuongNhanVien int,
	stt int
);
insert into PhongBan values ('PB1',N'Phòng kế toán','Lê Văn A','Z0.1',5,1);
insert into PhongBan values ('PB2',N'Phòng hành chính','Lê Văn B','Z0.2',5,2);
insert into PhongBan values ('PB3',N'Phòng kiểm toán','Lê Văn C','Z0.3',5,3);
insert into PhongBan values ('PB4',N'Phòng CSKH','Lê Văn D','Z0.4',5,4);
insert into PhongBan values ('PB5',N'Phòng nhân sự','Lê Văn E','Z0.5',5,5);
insert into PhongBan values ('PB6',N'Phòng CNTT','Lê Văn F','Z0.6',5,6);
insert into PhongBan values ('PB7',N'Phòng marketing','Lê Văn G','Z0.7',5,7);
insert into PhongBan values ('PB8',N'Phòng nghiên cứu & Phát triển SP','Lê Văn H','Z0.8',5,8);
insert into PhongBan values ('PB9',N'Phòng kinh doanh','Lê Văn I','Z0.9',5,9);
insert into PhongBan values ('PB10',N'Phòng thu mua','Lê Văn J','Z0.10',5,10);
--NhanVienHanhChinht table      select * from nhanvienhanhchinh select * from NhanVienHanhChinh
create table NhanVienHanhChinh(
	maNhanVien varchar(255),
	tenNhanVien NVARCHAR(255),
	namSinh int,
	gioiTinh nvarchar(255),
	ngayKhoiCong date,
	SDT varchar(255),
	stt int,

	maPhongBan varchar(255) foreign key references PhongBan(maPhongBan)
);
insert into NhanVienHanhChinh values ('NV1',N'Lê Văn A',1996,N'Nam','2016-12-02','03381885061',1,'PB1');
insert into NhanVienHanhChinh values ('NV2',N'Lê Văn B',1995,N'Nam','2016-11-02','03381885062',2,'PB2');
insert into NhanVienHanhChinh values ('NV3',N'Lê Văn C',1994,N'Nữ','2016-10-02','03381885063',3,'PB3');
insert into NhanVienHanhChinh values ('NV4',N'Lê Văn D',1993,N'Nam','2016-09-02','03381885064',4,'PB4');
insert into NhanVienHanhChinh values ('NV5',N'Lê Văn E',1992,N'Nam','2016-08-02','03381885065',5,'PB5');
insert into NhanVienHanhChinh values ('NV6',N'Lê Văn F',1991,N'Nữ','2016-07-02','03381885066',6,'PB6');
insert into NhanVienHanhChinh values ('NV7',N'Lê Văn G',1990,N'Nam','2016-06-02','03381885067',7,'PB7');
insert into NhanVienHanhChinh values ('NV8',N'Lê Văn H',1989,N'Nam','2016-05-02','03381885068',8,'PB8');
insert into NhanVienHanhChinh values ('NV9',N'Lê Văn I',1988,N'Nữ','2016-04-02','03381885069',9,'PB9');
insert into NhanVienHanhChinh values ('NV10',N'Lê Văn J',1987,N'Nam','2016-03-02','033818850610',10,'PB10');
--BangTangCa table select * from BangTangCa select sum(soGioTangCa),sum(28000*soGioTangCa*bonusCa) from BangTangCa where maNhanVien = 'NV1'
create table BangTangCa(
	maNhanVien varchar(255),
	soGioTangCa float,
	ngayTangCa Date,
	bonusCa float
);
insert into BangTangCa values ('NV1','5','2021-12-03',1.5);
insert into BangTangCa values ('NV1','8','2021-12-13',3);
insert into BangTangCa values ('NV2','5','2021-12-04',1.5);
insert into BangTangCa values ('NV3','5','2021-12-05',1.5);
insert into BangTangCa values ('NV4','5','2018-12-06',2);
insert into BangTangCa values ('NV5','5','2018-12-07',3);
insert into BangTangCa values ('NV6','5','2018-12-08',1.5);
insert into BangTangCa values ('NV7','5','2018-12-09',1.5);
insert into BangTangCa values ('NV8','5','2018-12-10',2);
insert into BangTangCa values ('NV9','5','2018-12-11',1.5);
insert into BangTangCa values ('NV10','5','2018-12-12',1.5);
--DonXinNghi table   select count(maNhanVien) from DonXinNghi where maNhanVien = 'NV1' and MONTH(ngayNghi) = 12;
create table DonXinNghi(
	maDonNghi varchar(255) PRIMARY KEY,
	maNhanVien varchar(255),
	tenNhanVien NVARCHAR(255),
	loaiNhanVien nvarchar(255),
	lyDoNghi NVARCHAR(255),
	ngayNghi date,
	loaiNghi nvarchar(255),
	stt int
);
insert into DonXinNghi values ('DN1','CN1',N'Nguyễn Văn A',N'Công nhân',N'Bệnh','2021-10-02',N'Không phép',1);
insert into DonXinNghi values ('DN2','CN2',N'Nguyễn Văn B',N'Công nhân',N'Bệnh','2021-12-02',N'Không phép',2);
insert into DonXinNghi values ('DN3','CN3',N'Nguyễn Văn C',N'Công nhân',N'Bệnh','2021-12-02',N'Có phép',3);
insert into DonXinNghi values ('DN4','CN4',N'Nguyễn Văn D',N'Công nhân',N'Bệnh','2021-12-02',N'Có phép',4);
insert into DonXinNghi values ('DN5','CN5',N'Nguyễn Văn E',N'Công nhân',N'Bệnh','2021-12-02',N'Không phép',5);
insert into DonXinNghi values ('DN6','NV1',N'Lê Văn A',N'Nhân viên',N'Bệnh','2021-12-02',N'Không phép',6);
insert into DonXinNghi values ('DN7','NV2',N'Lê Văn B',N'Nhân viên',N'Bệnh','2021-12-02',N'Có phép',7);
insert into DonXinNghi values ('DN8','NV3',N'Lê Văn C',N'Nhân viên',N'Bệnh','2021-12-02',N'Không phép',8);
insert into DonXinNghi values ('DN9','NV4',N'Lê Văn D',N'Nhân viên',N'Bệnh','2021-12-02',N'Có phép',9);
insert into DonXinNghi values ('DN10','NV5',N'Lê Văn E',N'Nhân viên',N'Bệnh','2021-12-02',N'Không phép',10);
--Staff table   select * from NguoiDUng
create table NguoiDung(
	tenDangNhap varchar(255),
	matKhau varchar(255),
	maNguoiDung nvarchar(255) PRIMARY KEY,
	tenNguoiDung nvarchar(255),
	phanQuyen varchar(255),
	thoiGianHoatDong int
);
insert into NguoiDung values ('admin','1','SUPER_ADMIN_01',N'PHAN TẤN TÀI','admin',0);
insert into NguoiDung values ('phantantai','087663az','SUPER_VISOR_02',N'NGUYỄN TRỌNG ĐẠT','user',1);