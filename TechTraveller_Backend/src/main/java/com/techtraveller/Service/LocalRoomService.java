package com.techtraveller.Service;


import java.util.List;

import com.techtraveller.Dto.LocalRoomDto;

public interface LocalRoomService {

    LocalRoomDto createLocalRoom(LocalRoomDto localRoomDto, String roomProviderId);
    LocalRoomDto updateLocalRoom(LocalRoomDto localRoomDto, String localRoomId, String roomProviderId);
    LocalRoomDto getLocalRoomById(String id);
    List<LocalRoomDto> getAllLocalRooms();
    List<LocalRoomDto> getAllLocalRoomsRoomProviderId(String roomProviderId);
    
    void deleteLocalRoom(String id);
}
