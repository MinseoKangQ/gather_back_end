package org.example.gather_back_end.user.dto;

import java.util.List;
import lombok.Builder;
import org.example.gather_back_end.creator.dto.filtering.CreatorInfo;

@Builder
public record GetMyPageRes(
        GetMyPageProfileInfo profileInfo, // 프로필 정보
        List<GetMyPagePromotionRes> promotionInfo, // 홍보 전략 요청 사항
        List<CreatorInfo> creatorInfo // 내가 조회한 크리에이터 목록
) {
}
