package com.techtraveller.Service;
import com.techtraveller.Dto.RoomDto;
import java.util.List;

public interface RoomService {

    RoomDto createRoom(RoomDto roomDto, String ownerId);

    RoomDto updateRoom(String roomId, RoomDto roomDto);

    RoomDto getRoomById(String roomId);

    List<RoomDto> getAllRooms();

    List<RoomDto> getRoomsByOwner(String ownerId);

    void deleteRoom(String roomId);
}
