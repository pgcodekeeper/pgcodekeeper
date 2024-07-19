CREATE TABLE [dbo].[Table_1](
	[col1] [nchar] COLLATE Cyrillic_General_CI_AS NULL,
	[col2] [int] NULL,
	[col3] [text] COLLATE Cyrillic_General_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
WITH (DATA_COMPRESSION = PAGE)
GO

CREATE TABLE [dbo].[Table_2](
    [column1] [nchar] COLLATE Cyrillic_General_CI_AS NULL,
    [column2] [int] NULL,
    [column3] [text] COLLATE Cyrillic_General_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
WITH (DATA_COMPRESSION = PAGE)
GO

CREATE PROCEDURE [dbo].[test_poc]
AS
SELECT col1 AS ThisDB,
        tab2.column3,
		p.col2,
		column2
From dbo.Table_1 p
LEFT JOIN dbo.Table_2 tab2 ON tab2.column1 = p.col1;
GO
