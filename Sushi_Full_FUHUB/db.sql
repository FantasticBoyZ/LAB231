USE [master]
GO
/****** Object:  Database [J3SP0013_Sushi_Restaurant]    Script Date: 3/17/2021 9:59:55 PM ******/
CREATE DATABASE [J3SP0013_Sushi_Restaurant]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'J3SP0013_Sushi_Restaurant', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\J3SP0013_Sushi_Restaurant.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'J3SP0013_Sushi_Restaurant_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\J3SP0013_Sushi_Restaurant_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3SP0013_Sushi_Restaurant].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET ARITHABORT OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET  ENABLE_BROKER 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET RECOVERY FULL 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET  MULTI_USER 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET DB_CHAINING OFF 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'J3SP0013_Sushi_Restaurant', N'ON'
GO
USE [J3SP0013_Sushi_Restaurant]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 3/17/2021 9:59:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Contact](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[address] [nvarchar](1000) NULL,
	[tel] [varchar](20) NULL,
	[email] [varchar](100) NULL,
	[openHours] [ntext] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Home]    Script Date: 3/17/2021 9:59:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Home](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](255) NULL,
	[image] [varchar](255) NULL,
	[description] [ntext] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Menu]    Script Date: 3/17/2021 9:59:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Menu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[price] [float] NULL,
	[shortDesc] [nvarchar](255) NULL,
	[detailDesc] [ntext] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SocialNetwork]    Script Date: 3/17/2021 9:59:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SocialNetwork](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[icon] [varchar](255) NULL,
	[link] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[View]    Script Date: 3/17/2021 9:59:56 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[View](
	[viewed] [int] NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Contact] ON 

INSERT [dbo].[Contact] ([id], [name], [address], [tel], [email], [openHours]) VALUES (1, N'The Sushi Restaurant', N'New York, NY, USA', N'12345', N'your-email@your-email.com', N'Monday Closed<br>  Tuesday 12 - 22<br> Wednesday 12 - 22<br> Thursday 12 - 22<br>
 Friday 11 - 23<br>
  Saturday 11 - 23<br>
Sunday 11 - 22')
SET IDENTITY_INSERT [dbo].[Contact] OFF
SET IDENTITY_INSERT [dbo].[Home] ON 

INSERT [dbo].[Home] ([id], [title], [image], [description]) VALUES (1, N'24 types of sushi rolls', N'/sushi-king.com/view/image/home2.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.')
INSERT [dbo].[Home] ([id], [title], [image], [description]) VALUES (2, N'24 types of sushi rolls', N'/sushi-king.com/view/image/home2.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.')
SET IDENTITY_INSERT [dbo].[Home] OFF
SET IDENTITY_INSERT [dbo].[Menu] ON 

INSERT [dbo].[Menu] ([id], [name], [price], [shortDesc], [detailDesc]) VALUES (1, N'Menu 1', 15, N'Claritas est etiam processus', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.')
INSERT [dbo].[Menu] ([id], [name], [price], [shortDesc], [detailDesc]) VALUES (2, N'
Menu 2', 20, N'Duis autem vel eum iriure dolor.	', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.')
INSERT [dbo].[Menu] ([id], [name], [price], [shortDesc], [detailDesc]) VALUES (3, N'Menu 3', 25, N'Eodem modo typi, qui nunc nobis videntur.', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.')
INSERT [dbo].[Menu] ([id], [name], [price], [shortDesc], [detailDesc]) VALUES (4, N'Menu 4', 22, N'Eodem modo typi, qui nunc nobis videntur.', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.')
INSERT [dbo].[Menu] ([id], [name], [price], [shortDesc], [detailDesc]) VALUES (5, N'Menu 5', 33, N'Duis autem vel eum iriure dolor.	', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.')
INSERT [dbo].[Menu] ([id], [name], [price], [shortDesc], [detailDesc]) VALUES (6, N'Menu 6', 33, N'ssssssssssssssssss', N'ssssssssssssssssss')
INSERT [dbo].[Menu] ([id], [name], [price], [shortDesc], [detailDesc]) VALUES (7, N'Menu 7', 22, N'aaaaaaaaaaaaa', N'bbbbbbbbbbbbb')
INSERT [dbo].[Menu] ([id], [name], [price], [shortDesc], [detailDesc]) VALUES (8, N'Menu 8', 66, N'sssssssssss', N'bbbbbbbbbbbbb')
SET IDENTITY_INSERT [dbo].[Menu] OFF
SET IDENTITY_INSERT [dbo].[SocialNetwork] ON 

INSERT [dbo].[SocialNetwork] ([id], [name], [icon], [link]) VALUES (1, N'Facebook', N'icon-facebook', N'https://www.facebook.com/')
INSERT [dbo].[SocialNetwork] ([id], [name], [icon], [link]) VALUES (2, N'Twitter', NULL, N'https://twitter.com/')
INSERT [dbo].[SocialNetwork] ([id], [name], [icon], [link]) VALUES (3, N'Instagram', NULL, N'https://www.instagram.com/')
SET IDENTITY_INSERT [dbo].[SocialNetwork] OFF
INSERT [dbo].[View] ([viewed]) VALUES (12)
USE [master]
GO
ALTER DATABASE [J3SP0013_Sushi_Restaurant] SET  READ_WRITE 
GO
