package com.techtraveller.Service;

import java.util.List;

import com.techtraveller.Dto.RoomProviderDto;

public interface RoomProviderService {
    RoomProviderDto createRoomProvider(RoomProviderDto roomProviderDto);

    RoomProviderDto updateRoomProvider(String id, RoomProviderDto roomProviderDto);

    RoomProviderDto getRoomProviderById(String id);

    List<RoomProviderDto> getAllRoomProviders();

    void deleteRoomProvider(String id);
}
