/****** Object:  Table [dbo].[scores]    Script Date: 18-6-2023 13:26:46 ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[scores]') AND type in (N'U'))
DROP TABLE [dbo].[scores]
GO

/****** Object:  Table [dbo].[scores]    Script Date: 18-6-2023 13:26:46 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[scores](
	[scoreId] [int] IDENTITY(1,1) NOT NULL,
	[keystrokes] [int] NOT NULL,
	[mouseclicks] [int] NULL,
	[score] [int] NOT NULL,
	[elapsedTime] [datetime] NULL,
	[createdAt] [datetime] NULL,
 CONSTRAINT [PK_scores] PRIMARY KEY CLUSTERED
(
	[scoreId] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO