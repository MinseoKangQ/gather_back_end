package org.example.gather_back_end.creator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.gather_back_end.creator.dto.CreateCreatorReq;
import org.example.gather_back_end.creator.dto.filtering.CreatorInfo;
import org.example.gather_back_end.util.response.PageResponse;
import org.example.gather_back_end.util.response.SuccessResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Tag(name = "크리에이터 관련", description = "크리에이터 관련된 API")
public interface CreatorControllerApi {

    @Operation(summary = "크리에이터 등록 완료")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "크리에이터 등록 완료",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = """
                                    {
                                        "timestamp": "2024-11-03T05:07:47.704694",
                                        "isSuccess": true,
                                        "code": "200",
                                        "message": "호출에 성공하였습니다.",
                                        "data": null
                                    }
                                    """
                                    ),
                            schema = @Schema(implementation = SuccessResponse.class)))
    })
    @PostMapping
    SuccessResponse<?> createCreator(
            Authentication authentication,
            @RequestPart CreateCreatorReq req,  // 이름, 소개 제목, 소개글, 카카오 아이디, 이메일
            @RequestPart MultipartFile profileImgUrl, // 프로필 사진
            @RequestPart List<MultipartFile> thumbnailImgUrlList,  // 썸네일 이미지
            @RequestPart List<MultipartFile> portfolioPdfList    // 포트폴리오
    ) throws Exception;

    @Operation(summary = "크리에이터 상세 페이지 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "크리에이터 상세 페이지 조회 nickname = 크리에이터명",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = """
                                            {
                                                "nickname": "USER8543",
                                                "profileImgUrl": "https~~",
                                                "introductionTitle": "내가 최고라서",
                                                "introductionContent": "저한테 맡겨만 주세요",
                                                "getPortfolioResList": [
                                                    {
                                                        "title": "제 첫번째 작품입니다.",
                                                        "thumbnailImgUrl": "https~",
                                                        "fileUrl": "https~"
                                                    },
                                                    {
                                                        "title": "제 두번째 작품입니다.",
                                                        "thumbnailImgUrl": "https~",
                                                        "fileUrl": "https~"
                                                    }
                                                ],
                                                "getWorkResList": [
                                                    {
                                                        "title": "포토샵",
                                                        "period": 13,
                                                        "startPrice": 25000,
                                                        "category": "SNS"
                                                    }
                                                ],
                                                "contactKakaoId": "jackcoke",
                                                "contactEmail": "jackcoke@gmail.com"
                                            }"""),
                            schema = @Schema(implementation = SuccessResponse.class)))
    })
    @GetMapping
    SuccessResponse<?> getCreator(Authentication authentication, @PathVariable String nickname);

    @Operation(summary = "크리에이터 등록 초기 화면 불러 오기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "크리에이터 등록 초기화면 불러오기 즉 크리에이터 등록을 클릭 시"
                    +" 기존에 저장 되어 있던 크리에이터 정보 불러 온다.",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = """
                                            {
                                                "nickname": "USER8543",
                                                "profileImgUrl": "https~~",
                                                "introductionTitle": "내가 최고라서",
                                                "introductionContent": "저한테 맡겨만 주세요",
                                                "getPortfolioResList": [
                                                    {
                                                        "title": "제 첫번째 작품입니다.",
                                                        "thumbnailImgUrl": "https~",
                                                        "fileUrl": "https~"
                                                    },
                                                    {
                                                        "title": "제 두번째 작품입니다.",
                                                        "thumbnailImgUrl": "https~",
                                                        "fileUrl": "https~"
                                                    }
                                                ],
                                                "getWorkResList": [
                                                    {
                                                        "title": "포토샵",
                                                        "period": 13,
                                                        "startPrice": 25000,
                                                        "category": "SNS"
                                                    }
                                                ],
                                                "contactKakaoId": "jackcoke",
                                                "contactEmail": "jackcoke@gmail.com"
                                            }"""),
                            schema = @Schema(implementation = SuccessResponse.class)))
    })
    @GetMapping
    SuccessResponse<?> getCreatorInfo(Authentication authentication);

    @Operation(summary = "크리에이터 찾기")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "크리에이터 찾기에서 사용되는 API",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = """
                                    {
                                        "timestamp": "2024-11-14T21:39:55.407616",
                                        "isSuccess": true,
                                        "code": "200",
                                        "message": "호출에 성공하였습니다.",
                                        "data": {
                                            "totalPage": 1,
                                            "totalElements": 3,
                                            "pagingSize": 12,
                                            "currentPage": 1,
                                            "isFirst": true,
                                            "isLast": true,
                                            "isEmpty": false,
                                            "data": [
                                                {
                                                    "nickname": "USER4255",
                                                    "availableWork": [
                                                        "SNS"
                                                    ],
                                                    "introductionTitle": "sds",
                                                    "startPrice": "49000",
                                                    "thumbnailImgUrl": null
                                                },
                                                {
                                                    "nickname": "USER3322",
                                                    "availableWork": [
                                                        "인쇄물",
                                                        "SNS"
                                                    ],
                                                    "introductionTitle": "dkssudd",
                                                    "startPrice": "500",
                                                    "thumbnailImgUrl": "ㅇㅇ"
                                                },
                                                {
                                                    "nickname": "USER3333",
                                                    "availableWork": [
                                                        "SNS"
                                                    ],
                                                    "introductionTitle": "dfdfdfdfdfdfdfdf",
                                                    "startPrice": "1000",
                                                    "thumbnailImgUrl": null
                                                }
                                            ]
                                        }
                                    }
                            """
                            ),
                            schema = @Schema(implementation = SuccessResponse.class)
                    )
            )
    })
    @GetMapping
    SuccessResponse<PageResponse<CreatorInfo>> filteringCreator(
            @PageableDefault(size = 12, page = 0) Pageable pageable,
            @Parameter(
                    description = """
                        가격 필터링 기준 (선택)
                        - 1만원 미만 : 10000
                        - 5만원 미만 : 50000
                        - 10만원 미만 : 100000
                        - 20만원 미만 : 200000
                        - 20만원 이상 : 200001
                    """,
                    example = "50000"
            )
            @RequestParam(value = "price", required = false) Integer price,
            @Parameter(description = "카테고리 필터링 기준 (선택): PRINTS, VIDEO, SNS_POST 중 하나", example = "PRINTS")
            @RequestParam(value = "category", required = false) String category,
            @Parameter(description = "정렬 기준 (선택): recently, lowPrice, highPrice 중 하나, 기본값은 recently", example = "lowPrice")
            @RequestParam(value = "align", defaultValue = "recently", required = false) String recently
    );

}
