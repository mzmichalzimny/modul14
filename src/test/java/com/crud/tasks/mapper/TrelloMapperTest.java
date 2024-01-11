package com.crud.tasks.mapper;
import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloMapperTest {

    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloListDto> trelloListDtos = Arrays.asList(new TrelloListDto("1", "Test list", false));
        List<TrelloBoardDto> trelloBoardDtos = Arrays.asList(new TrelloBoardDto("1", "Test board", trelloListDtos));

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals(trelloBoardDtos.get(0).getId(), trelloBoards.get(0).getId());
        assertEquals(trelloBoardDtos.get(0).getName(), trelloBoards.get(0).getName());
        assertEquals(trelloBoardDtos.get(0).getLists().size(), trelloBoards.get(0).getLists().size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloList> trelloLists = Arrays.asList(new TrelloList("1", "Test list", false));
        List<TrelloBoard> trelloBoards = Arrays.asList(new TrelloBoard("1", "Test board", trelloLists));

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(1, trelloBoardDtos.size());
        assertEquals(trelloBoards.get(0).getId(), trelloBoardDtos.get(0).getId());
        assertEquals(trelloBoards.get(0).getName(), trelloBoardDtos.get(0).getName());
        assertEquals(trelloBoards.get(0).getLists().size(), trelloBoardDtos.get(0).getLists().size());
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDtos = Arrays.asList(new TrelloListDto("1", "Test list", false));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals(1, trelloLists.size());
        assertEquals(trelloListDtos.get(0).getId(), trelloLists.get(0).getId());
        assertEquals(trelloListDtos.get(0).getName(), trelloLists.get(0).getName());
        assertEquals(trelloListDtos.get(0).isClosed(), trelloLists.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloLists = Arrays.asList(new TrelloList("1", "Test list", false));

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(1, trelloListDtos.size());
        assertEquals(trelloLists.get(0).getId(), trelloListDtos.get(0).getId());
        assertEquals(trelloLists.get(0).getName(), trelloListDtos.get(0).getName());
        assertEquals(trelloLists.get(0).isClosed(), trelloListDtos.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test name", "Test description", "Test pos", "Test listId");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test name", "Test description", "Test pos", "Test listId");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCardDto.getName(), trelloCard.getName());
        assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
        assertEquals(trelloCardDto.getPos(), trelloCard.getPos());
        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
    }
}