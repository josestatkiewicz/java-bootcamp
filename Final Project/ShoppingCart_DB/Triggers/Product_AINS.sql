use `_shoppingcart`;
delimiter |
create trigger `Product_AINS` after insert on `Product`
for each row
begin
	insert into `ItemToPurchase`(`product`,`itemType`) 
	value(new.idProduct,'Product');
end;
|
delimiter ;