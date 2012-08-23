CREATE DATABASE MySweetHome

drop database MySweetHome

USE MySweetHome

--use master 
------------------TypeOfMember-------------------------
CREATE TABLE TypeOfMember
(
	TypeOfMemberID nvarchar(30) constraint TypeOfMember_PK primary key,
	TypeName nvarchar(200)
)
INSERT INTO TypeOfMember VALUES ('1','Seller')
INSERT INTO TypeOfMember VALUES ('2','Buyer')

delete from TypeOfMember
------------------MEMBER-------------------------
CREATE TABLE Member
(
	UserName nvarchar(100) constraint Member_PK primary key,
	Password nvarchar(100),
	Email nvarchar(100),	
	Full_Name nvarchar(200),
	Date_Of_Birth nvarchar(20),
	Gender nvarchar(30),
	Address nvarchar(200),
	Telephone nvarchar(50),
	Company nvarchar(50),
	Is_Enabled nvarchar(10),
	Code nvarchar(100),
	ImageUrl nvarchar(250),
	Role nvarchar(10),
	Type_Of_Member_ID nvarchar(30) constraint Member_TypeOfMember_fk foreign key (Type_Of_Member_ID) references TypeOfMember (TypeOfMemberID)
)
INSERT INTO Member VALUES ('QHuy','12345','qhuy@gmail.com','Ngo Quang Huy','11/11/1989','male','12 Hai Ho','0905123456','GCafe','true','12345','','Admin','1')
INSERT INTO Member VALUES ('VLong','12345','vlong@gmail.com','Vu Long','11/12/1989','male','13 Hai Ho','0905123123','GCafe','true','12345','','Admin','2')
INSERT INTO Member VALUES ('QVinh','12345','qvinh@gmail.com','Huynh Quang Vinh','10/10/1989','male','15 Hai Ho','0905123654','GCafe','true','12345','','Member','1')
INSERT INTO Member VALUES ('ATan','12345','atan@gmail.com','Nguyen Anh Tan','5/11/1989','male','14 Hai Ho','0905123789','GCafe','true','12345','','Member','2')
INSERT INTO Member VALUES ('XTrung','12345','xtrung@gmail.com','Le Xuan Trung','9/11/1989','male','16 Hai Ho','0905123888','GCafe','true','12345','','Member','1')

--TypeOfEstate is: rent or sell
------------------TypeOfEstate-------------------------
CREATE TABLE TypeOfEstate
(
	TypeOfEstate_ID nvarchar(30) constraint TypeOfEstate_pk primary key,
	TypeOfEstate_Name nvarchar(200)
)
INSERT INTO TypeOfEstate VALUES ('MS001','House For Rent 1500USD Nguyen Thi Minh Khai, Dist1')
INSERT INTO TypeOfEstate VALUES ('MS002','Room For Rent 240_280_400 usd Q1,3,5,10... ')
INSERT INTO TypeOfEstate VALUES ('MS003','House For Rent 1300USD/month Quận1, HCM')
INSERT INTO TypeOfEstate VALUES ('MS004','House For Rent 1000USD , Dist1')
INSERT INTO TypeOfEstate VALUES ('MS005','Villa For Rent 15000USD Nguyen Thi Minh Khai, Dist1')

------------------Category-------------------------
CREATE TABLE Category
(
	Category_ID nvarchar(30) constraint Category_pk primary key,
	Category_Name nvarchar(200)
)
------------------Subscribe-------------------------
CREATE TABLE Subscribe
(
	Subscribe_ID nvarchar(30) constraint Subscribe_pk primary key,
	Subscribe_Name nvarchar(100),
	Fee_Per_Day nvarchar(20)
)

INSERT INTO Subscribe VALUES ('1','Vip 1','15000')
INSERT INTO Subscribe VALUES ('2','Vip 2','20000')
INSERT INTO Subscribe VALUES ('3','Vip 3','25000')


------------------City-------------------------
CREATE TABLE City
(
	City_ID nvarchar(30) constraint City_pk primary key,
	City_Name nvarchar(200)
)
INSERT INTO City VALUES ('01','HaNoi Capital')
INSERT INTO City VALUES ('02','HoChiMinh City')
INSERT INTO City VALUES ('03','Hai Phong City')
INSERT INTO City VALUES ('04','Da Nang City')
INSERT INTO City VALUES ('05','Ha Giang Province')


------------------District-------------------------
CREATE TABLE District
(
	District_ID nvarchar(30) constraint District_pk primary key,
	District_Name nvarchar(200),
	City_ID nvarchar(30) constraint City_District_fk foreign key (City_ID) references City (City_ID)
)
INSERT INTO District VALUES ('0201','District 1','002')
INSERT INTO District VALUES ('0202','District 2','002')
INSERT INTO District VALUES ('0203','District 3','002')
INSERT INTO District VALUES ('0204','District 4','002')
INSERT INTO District VALUES ('0205','District 5','002')

------------------Street-------------------------
--CREATE TABLE Street
--(
--	Street_ID nvarchar(30) constraint Street_pk primary key,
--	Street_Name nvarchar(200),
--	City_ID nvarchar(30) constraint City_Street_fk foreign key (City_ID) references City (City_ID),
--	District_ID nvarchar(30) constraint District_Street_fk foreign key (District_ID) references District (District_ID)
--)
--------------------Location-------------------------
--CREATE TABLE Location
--(
--	Location_ID  nvarchar(30) constraint Location_PK primary key,
--	--Estate_ID nvarchar(30) constraint Estate_Location_fk foreign key (Estate_ID) references Estate(Estate_ID),	
--	City_ID nvarchar(30) constraint City_Estate_fk foreign key (City_ID) references City(City_ID),
--	District_ID nvarchar(30) constraint District_Estate_fk foreign key (District_ID) references District(District_ID)
--)
--INSERT INTO Location VALUES ('Loca01','002','District 1')
--INSERT INTO Location VALUES ('Loca02','002','District 2')
--INSERT INTO Location VALUES ('Loca03','002','District 3')
--INSERT INTO Location VALUES ('Loca04','002','District 4')
--INSERT INTO Location VALUES ('Loca05','002','District 5')

------------------Currency-------------------------
CREATE TABLE Currency
(
	Currency_ID nvarchar(30) constraint Currency_pk primary key,
	Currency_Name nvarchar(200),
	--ti gia so voi dong viet nam (vd 1 USD = 20800 VND)
	VND_Rate nvarchar(20)
)
INSERT INTO Currency VALUES ('Cur01','USD','20800')
INSERT INTO Currency VALUES ('Cur02','EUR','25460')
INSERT INTO Currency VALUES ('Cur03','GBP','32391')
INSERT INTO Currency VALUES ('Cur04','JPY','263')
INSERT INTO Currency VALUES ('Cur05','RUB','597')

------------------Estate-------------------------
CREATE TABLE Estate
(
	Estate_ID nvarchar(30) constraint Estate_pk primary key,
	Estate_Title nvarchar(300),
	Estate_Start_Day nvarchar(15),
	Estate_End_Day nvarchar(15),
	Estate_Address nvarchar(200),
	Estate_Content nvarchar(max),
	Estate_Area nvarchar(50),
	Estate_Value nvarchar(30),
	--Estate_Driveway : duong truoc nha (3m, 5m, 10m,...)
	Estate_Driveway nvarchar(50),
	Estate_Direction nvarchar(30),
	Estate_Number_Of_Rooms nvarchar(30),
	Estate_Number_Of_Floors nvarchar(30),
	Estate_Number_Of_Toilets nvarchar(30),
	Estate_NumOfView nvarchar(100),
	Currency_ID nvarchar(30) constraint Currency_Estate_fk foreign key (Currency_ID) references Currency(Currency_ID),  		
	Is_Enabled nvarchar(5),
	Is_Paid nvarchar(5),
	--Subscribe : la loai tin dang: vip 1,2,3... 
	Subscribe_ID nvarchar(30) constraint Subscribe_Estate_fk foreign key (Subscribe_ID) references Subscribe (Subscribe_ID),
	--TypeOfEstate is: rent or sell
	TypeOfEstate_ID nvarchar(30) constraint TypeOfEstate_Estate_FK foreign key (TypeOfEstate_ID) references TypeOfEstate(TypeOfEstate_ID),
	--Category :villa, house, phong tro,....
	Category_ID nvarchar(30) constraint Category_Estate_fk foreign key (Category_ID) references Category(Category_ID),	
	--UserName: nguoi dang bai viet nay
	UserName nvarchar(100) constraint Member_Estate_fk foreign key (UserName) references Member(UserName),	
	--SumValue : dung de tinh tong gia tri cua tai san
	SumValue nvarchar(20),
	District_ID  nvarchar(30) constraint District_Estate_FK foreign key (District_ID) references District(District_ID),
	Contact_Details_ID nvarchar(30) constraint Contact_Details_Estate_FK foreign key (Contact_Details_ID) references Contact_Details(Contact_Details_ID),
	Image_Category_ID nvarchar(30) constraint Image_Category_Estate_FK foreign key (Image_Category_ID) references Image_Category(Image_Category_ID)
)

--tao bang chua images duoc uplen cho moi estate(max=6)
--image_1,...6 o day chinh la ten file anh
------------------Image_Category-------------------------
CREATE TABLE Image_Category
(
	Image_Category_ID nvarchar(30) constraint Image_Category_pk primary key,
	--Estate_ID nvarchar(30) constraint Estate_Image_Category_fk foreign key (Estate_ID) references Estate(Estate_ID),	
	--khi add them image vao bang thi them Estate_ID vao truoc ten file anh. Vd: Estate001_myhome.jpg
	Image_1 nvarchar(200),
	Image_2 nvarchar(200),
	Image_3 nvarchar(200),
	Image_4 nvarchar(200),
	Image_5 nvarchar(200),
	Image_6 nvarchar(200)
)
INSERT INTO Contact_Details VALUES ('Contact01','Quang Thien','160 Quang Trung','qthien@gmail.com','0905123123')
INSERT INTO Contact_Details VALUES ('Contact02','Quang Thien','160 Quang Trung','qthien@gmail.com','0905123123')
INSERT INTO Contact_Details VALUES ('Contact03','Quang Thien','160 Quang Trung','qthien@gmail.com','0905123123')
INSERT INTO Contact_Details VALUES ('Contact04','Quang Thien','160 Quang Trung','qthien@gmail.com','0905123123')
INSERT INTO Contact_Details VALUES ('Contact05','Quang Thien','160 Quang Trung','qthien@gmail.com','0905123123')

--------------------Contact-------------------------
--CREATE TABLE Contact
--(
--	Contact_ID nvarchar(30) constraint Contact_pk primary key,
--	ContactDetails_ID constraint Estate_Contact_fk foreign key (Estate_ID) references Estate(Estate_ID),
--	Estate_ID nvarchar(30) constraint Estate_Contact_fk foreign key (Estate_ID) references Estate(Estate_ID),
--)
------------------Contact_Details-------------------------
CREATE TABLE Contact_Details
(
	Contact_Details_ID nvarchar(30) constraint Contact_Details_pk primary key,
	--Estate_ID nvarchar(30) constraint Estate_Contact_Details_fk foreign key (Estate_ID) references Estate(Estate_ID),
	Contact_Name nvarchar(200),
	Contact_Address nvarchar(200),
	Contact_Email nvarchar(100),
	Contact_Telephone nvarchar(50)
)

------------------News-------------------------
create table News
(
	News_ID nvarchar(30) constraint News_PK primary key,
	News_Title nvarchar(500),
	News_Contents nvarchar(max),
	News_Image nvarchar(max)
)
INSERT INTO News VALUES ('New01','','','')
INSERT INTO News VALUES ('New02','','','')
INSERT INTO News VALUES ('New03','','','')
INSERT INTO News VALUES ('New04','','','')
INSERT INTO News VALUES ('New05','','','')

-----------------TransactionDetails-----------------
CREATE TABLE Transaction_Details
(
	Trans_ID nvarchar(30) constraint Trans_pk primary key,
	UserName nvarchar(100) constraint Member_Transaction_Details_fk foreign key (UserName) references Member(UserName),
	Trans_Time nvarchar(30),
	Trans_Money nvarchar(30),
	Trans_Detail nvarchar(max)
)
INSERT INTO Transaction_Details VALUES ('Tran01','Truong Van Loi','30 Day','15000 USD','Selling the house is located on the road Cao Xuan Huy, Vinh City, Nghe An')
INSERT INTO Transaction_Details VALUES ('Tran02','Truong Trang','30 Day','1000 USD','Rentals 268 Truong Chinh road, Vinh City, Nghe An')
INSERT INTO Transaction_Details VALUES ('Tran03','Truong Thien','30 Day','12000 USD','Land DISTRICT 9, HCM City, Do Xuan Hop front, 14.5 million/m2 price only')


-----------------Account-----------------
CREATE TABLE Account
(
	Account_Number nvarchar(30) constraint Account_pk primary key,
	Account_Password nvarchar(100),
	Account_Name nvarchar(200),
	Account_Email nvarchar(100),
	Account_Telephone nvarchar(50),
	Account_Balance nvarchar(50)
)
INSERT INTO Account VALUES('111','12345','QHuy','qhuy@gmail.com','0905123456','')

-----------------FAQs-----------------
CREATE TABLE FAQs
(
	FAQs_ID nvarchar(50) constraint FAQs_pk primary key,
	Question nvarchar(250),
	Answer nvarchar(max)
)
