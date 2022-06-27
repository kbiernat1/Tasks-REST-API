package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TrelloMapperTest {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    void mapToBoardsTest() {
        //given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "first list", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "second list", false);

        List<TrelloListDto> trelloListsDto1 = Arrays.asList(trelloListDto1, trelloListDto2);
        List<TrelloListDto> trelloListsDto2 = Arrays.asList(trelloListDto1, trelloListDto2);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "first board", trelloListsDto1);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "second board", trelloListsDto2);

        List<TrelloBoardDto> trelloBoardsDto = Arrays.asList(trelloBoardDto1, trelloBoardDto2);

        //when
        List<TrelloBoard> list = trelloMapper.mapToBoards(trelloBoardsDto);

        //then
        assertEquals(trelloBoardsDto.get(0).getId(), list.get(0).getId());
        assertEquals(trelloListDto2.getId(), list.get(1).getLists().get(1).getId());
    }

    @Test
    void mapToBoardsDtoTest() {
        //given
        TrelloList trelloList1 = new TrelloList("1", "first list", false);
        TrelloList trelloList2 = new TrelloList("2", "second list", false);

        List<TrelloList> trelloLists1 = Arrays.asList(trelloList1, trelloList2);
        List<TrelloList> trelloLists2 = Arrays.asList(trelloList1, trelloList2);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "first board", trelloLists1);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "second board", trelloLists2);

        List<TrelloBoard> trelloBoards = Arrays.asList(trelloBoard1, trelloBoard2);

        //when
        List<TrelloBoardDto> list = trelloMapper.mapToBoardsDto(trelloBoards);

        //then
        assertEquals(trelloBoards.get(0).getId(), list.get(0).getId());
        assertEquals(trelloList2.getId(), list.get(1).getLists().get(1).getId());
    }

    @Test
    void mapToListTest() {
        //given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "first list", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "second list", false);
        List<TrelloListDto> trelloListsDto = Arrays.asList(trelloListDto1, trelloListDto2);

        //when
        List<TrelloList> list = trelloMapper.mapToList(trelloListsDto);

        //then
        assertEquals(trelloListsDto.get(0).getId(), list.get(0).getId());
        assertEquals(trelloListsDto.get(0).isClosed(), list.get(0).isClosed());
    }

    @Test
    void mapToListDtoTest() {
        //given
        TrelloList trelloList1 = new TrelloList("1", "first list", false);
        TrelloList trelloList2 = new TrelloList("2", "second list", false);
        List<TrelloList> trelloLists = Arrays.asList(trelloList1, trelloList2);

        //when
        List<TrelloListDto> list = trelloMapper.mapToListDto(trelloLists);

        //then
        assertEquals(trelloLists.get(1).getId(), list.get(1).getId());
        assertEquals(trelloLists.get(0).isClosed(), list.get(0).isClosed());
    }

    @Test
    void mapToCardDtoTest() {
        //given
        TrelloCard trelloCard = new TrelloCard("To do", "things to do", "top", "1");

        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //then
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }

    @Test
    void mapToCardTest() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("To do", "things to do", "top", "1");

        //when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //then
        assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
    }
}
