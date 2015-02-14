INSERT INTO `_shoppingcart`.`ShoppingCart` (`idShoppingCart`, `user`) 
VALUES ('1', '1');

INSERT INTO `_shoppingcart`.`ProductsForShoppingCart` (`shoppingCart`, `product`, `quantity`)
VALUES 	('1', '1', '1'),
		('1', '14', '2');

INSERT INTO `_shoppingcart`.`OfferForShoppingCart` (`shoppingCart`, `offer`, `quantity`)
VALUES 	('1', '1', '1'),
		('1', '2', '2');