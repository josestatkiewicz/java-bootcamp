use `_shoppingcart`;
delimiter |
create trigger `Offer_AINS` after insert on `Offer`
for each row
begin
	insert into `ItemToPurchase`(`offer`,`itemType`) 
	value(new.idOffer,'Offer');
end;
|
delimiter ;