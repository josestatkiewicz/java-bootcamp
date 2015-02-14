use `_shoppingcart`;
delimiter |
create trigger `ItemsForShoppingCart_AINS` before insert on `ItemsForShoppingCart`
for each row
begin
	if((select ITP.itemType
		from ItemToPurchase ITP
		where ITP.idItem = new.item) = 'Product') then 
		set new.price = new.quantity * (select P.price
										from Product P, ItemToPurchase ITP, ItemsForShoppingCart IFSC
										where (new.item = ITP.idItem and ITP.product = P.idProduct));
		else if ((	select ITP.itemType
					from ItemToPurchase ITP
					where ITP.idItem = new.item) = 'Offer') then 
			set new.price = new.quantity * (select O.price
											from Offer O, ItemToPurchase ITP, ItemsForShoppingCart IFSC
											where (new.item = ITP.idItem and ITP.offer = O.idOffer));
		end if;
	end if;
end;
|
delimiter ;
