package com.lpu.studentManagement.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class FileData {
	private String fileName;
	private String fieldType;
	@Lob
	private byte[] data;
}
