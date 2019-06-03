package org.trello4j;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.trello4j.model.Board;
import org.trello4j.model.Card;

/**
 * @author Johan Mynhardt
 */
public class CardServiceTest {

    // Note: this url was used to generate token with read, write permissions:
    // https://trello.com/1/authorize?key=23ec668887f03d4c71c7f74fb0ae30a4&name=My+Application&expiration=never&response_type=token&scope=read,write

    private static final String API_KEY = "b1f642981a2c81b2c0c7c22a05e8f34e";
    private static final String API_TOKEN = "19b51e01ddb45caeab55e72b584da04ba4bbc8b40a00a482097f8c7339d671a8";

    @Test
	public void getBoard() {
      
        // WHEN
		Board board = new TrelloImpl(API_KEY, API_TOKEN).getBoard("5b64871e74145215f944ae6b");

        // THEN
		assertNotNull(board);
	}
    
    @Test
 	public void getCards() {
       
         // WHEN
 		List<Card> cards = new TrelloImpl(API_KEY, API_TOKEN).getCardsByBoard("5b64871e74145215f944ae6b",null);

         // THEN
 		assertNotNull(cards);
 	}
     
    
    
    @Test
 	public void getListas() {
       
         // WHEN
 		List<org.trello4j.model.List> listas = new TrelloImpl(API_KEY, API_TOKEN).getListByBoard("5b64871e74145215f944ae6b",null);

         // THEN
 		assertNotNull(listas);
 	}
    
    
    @Test
 	public void getCardsByList() {
       
    	List<org.trello4j.model.List> listas = new TrelloImpl(API_KEY, API_TOKEN).getListByBoard("5b64871e74145215f944ae6b",null);
    	
         // WHEN
 		List<Card> cards = new TrelloImpl(API_KEY, API_TOKEN).getCardsByList(listas.get(0).getId(), null);

         // THEN
 		assertNotNull(cards);
 	}
    
    /*
    @Test
	public void testCreateCard() {
        // GIVEN
        String listId = "555c8e8438613a1b6f665efc";
		String name = "First List";
		String description = "Something awesome happened :)";

		Map<String, String> map = new HashMap<String, String>();
        map.put("desc", description);

        // WHEN
		Card card = new TrelloImpl(API_KEY, API_TOKEN).createCard(listId, name, map);

        // THEN
		assertNotNull(card);
		assertThat(card.getName(), equalTo(name));
		assertThat(card.getDesc(), equalTo(description));
	}
    
    */
}
