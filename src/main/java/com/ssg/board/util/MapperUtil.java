package com.ssg.board.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
