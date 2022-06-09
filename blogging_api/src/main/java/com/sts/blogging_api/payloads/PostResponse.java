package com.sts.blogging_api.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostResponse {
	
	private List<PostDto> postList;
	private int pageNumber;
	private int pageSize;
	private int totalPages;
	private boolean lastPage;

}
