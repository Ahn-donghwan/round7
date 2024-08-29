package com.sparta.round7.controller;

import com.sparta.round7.dto.*;
import com.sparta.round7.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardSaveResponseDto> saveBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        return ResponseEntity.ok(boardService.saveBoard(boardSaveRequestDto));
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardSimpleResponseDto>> getBoards(){
        return ResponseEntity.ok(boardService.getBoards());
    }

    @GetMapping("/boards/{boardId}")
    public ResponseEntity<BoardDetailResponseDto> getBoard(@PathVariable Long boardId){
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<UpdateBoardTitleResponseDto> updateBoardTitle(@PathVariable Long boardId, @RequestBody UpdateBoardTitleRequestDto updateBoardTitleRequestDto){
        return ResponseEntity.ok(boardService.updateBoardTitle(boardId, updateBoardTitleRequestDto));
    }

    @PutMapping("/boards/{boardId}")
    public UpdateBoardContentsResponseDto updateBoardContents(@PathVariable Long boardId, @RequestBody UpdateBoardContentsRequestDto updateBoardContentsRequestDto){
        return boardService.updateBoardContents(boardId, updateBoardContentsRequestDto);
    }

    @DeleteMapping("/boards/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) { boardService.deleteBoard(boardId); }
}
