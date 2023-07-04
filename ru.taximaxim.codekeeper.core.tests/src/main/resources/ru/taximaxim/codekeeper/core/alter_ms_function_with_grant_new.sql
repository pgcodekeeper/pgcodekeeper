SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[functest2] (@a int, @b int)
returns table 
as return
select 2 as first
GO

GRANT SELECT ON [dbo].[functest2] TO [public_2]
GO