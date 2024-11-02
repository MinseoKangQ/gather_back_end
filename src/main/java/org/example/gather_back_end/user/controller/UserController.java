package org.example.gather_back_end.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.gather_back_end.bucket.service.BucketService;
import org.example.gather_back_end.user.dto.UploadProfileImgRes;
import org.example.gather_back_end.util.response.SuccessResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final BucketService bucketService;

    @PostMapping("/{userId}/profileImg")
    public SuccessResponse<UploadProfileImgRes> uploadProfileImg(
            @PathVariable Long userId,
            @RequestParam("file") MultipartFile file) throws Exception {
        UploadProfileImgRes res = bucketService.uploadProfileImg(file, userId);
        return SuccessResponse.of(res);
    }
}
