/****** Object:  Table [dbo].[users]    Script Date: 18-6-2023 13:28:07 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[users]') AND type in (N'U'))
DROP TABLE [dbo].[users]
GO

/****** Object:  Table [dbo].[users]    Script Date: 18-6-2023 13:28:07 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[firstname] [varchar](20) NOT NULL,
	[lastname] [varchar](50) NOT NULL,
	[streetname] [varchar](50) NOT NULL,
	[postalcode] [varchar](6) NOT NULL,
	[housenumber] [nchar](4) NOT NULL,
	[city] [varchar](50) NOT NULL,
	[country] [varchar](50) NOT NULL,
	[phonenumber] [nchar](10) NOT NULL,
	[emailadress] [varchar](50) NOT NULL,
	[password] [varchar](10) NOT NULL,
	[registred] [bit] NOT NULL,
 CONSTRAINT [PK__users__3213E83FD8ED7ACD] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO