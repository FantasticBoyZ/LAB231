select ar.id,title,[image],content,au.name as [Author Name],[date] from Article ar,Author au where ar.authorID = au.id
and ar.id = 2

select *from(select ROW_NUMBER() over (order by ar.ID ASC) as row_index, ar.id,title,[image],content,au.name as [Author Name],[date] 
					from Article ar,Author au 
					where ar.authorID = au.id 
					and title 
                    like '%a%'
                    )as x
                    where row_index between 2*3-2
                    and 2*3

select count(*) from Article
                    where title like '%ma%'