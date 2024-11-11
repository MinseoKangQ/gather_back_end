package org.example.gather_back_end.promotion.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.gather_back_end.promotion.dto.cost.PromotionCostReq;
import org.example.gather_back_end.promotion.dto.cost.PromotionCostRes;
import org.example.gather_back_end.promotion.dto.timeline.PromotionTimelineReq;
import org.example.gather_back_end.promotion.dto.timeline.PromotionTimelineRes;
import org.example.gather_back_end.promotion.service.PromotionService;
import org.example.gather_back_end.util.jwt.dto.CustomOAuth2User;
import org.example.gather_back_end.util.response.SuccessResponse;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/promotion")
public class PromotionController implements PromotionControllerApi {

    private final PromotionService promotionService;


    @PostMapping("/timeline")
    public SuccessResponse<List<PromotionTimelineRes>> createPromotionTimeline(
            Authentication authentication,
            @RequestBody PromotionTimelineReq req) {
        CustomOAuth2User user = (CustomOAuth2User) authentication.getPrincipal();
        String providerId = user.getUsername();
        List<PromotionTimelineRes> res = promotionService.createPromotionStrategy(req, providerId);
        return SuccessResponse.of(res);
    }

    @PostMapping("/cost-management")
    public SuccessResponse<List<PromotionCostRes>> createPromotionCost(
            Authentication authentication,
            @RequestBody PromotionCostReq req) {
        CustomOAuth2User user = (CustomOAuth2User) authentication.getPrincipal();
        String providerId = user.getUsername();
        List<PromotionCostRes> res = promotionService.createPromotionCost(req);
        return SuccessResponse.of(res);
    }
}
