package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

	@Mock
	ItemRepository repository;

	@InjectMocks
	ItemBusinessService business;

	@Test
	void testRetreiveHardcodedItem() {
		ItemBusinessService businessService = new ItemBusinessService();
		Item item = new Item(1, "Ball", 10, 100);
		Item saved = businessService.retreiveHardcodedItem();
		assertNotNull(saved);
		assertEquals(item,saved);
	}

	@Test
	void testSaveItem() {
		Item item = new Item(2, "Item2", 20, 20);
		when(repository.save(item)).thenReturn(item);
		Item saved = business.saveItem(item);
		assertEquals(item.getName(), saved.getName());
	}

	@Test
	void testSaveWithNoNameThrowException() {
		Item item = new Item(2, null, 20, 20);
//			when(repository.save(item)).thenThrow(new ParameterMissingException("Name paratmer is Null"));
		try {
			Item saved =business.saveItem(item);
		} catch (Exception e) {
			assertNotNull(e);
			assertEquals(ParameterMissingException.class, e.getClass());
		}
	}

	@Test
	void testUpdateItem() {
		Item item = new Item(2, "Item2", 20, 20);
		when(repository.saveAndFlush(item)).thenReturn(item);
		Item saved = business.updateItem(item);
		assertEquals(item.getName(), saved.getName());
	}

	@Test
	void testRetrieveAllItems() {
		List<Item> items = Arrays.asList(new Item(2, "Item2", 20, 20), new Item(3, "Item3", 20, 20));
		when(repository.findAll())
				.thenReturn(Arrays.asList(new Item(2, "Item2", 20, 20), new Item(3, "Item3", 20, 20)));// Mocking
//		ItemBusinessService businessService = new ItemBusinessService();
		List<Item> saved = business.retrieveAllItems();
		assertEquals(saved.get(0).getName(), items.get(0).getName());
	}

	@Test
	void testRetrieveAllItemsWithZeroItems() {
		when(repository.findAll()).thenReturn(Arrays.asList());// Mocking
//		ItemBusinessService businessService = new ItemBusinessService();
		business.retrieveAllItems();
	}

}
