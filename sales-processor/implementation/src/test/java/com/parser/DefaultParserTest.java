package com.parser;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultParserTest {

    @Test
    public void shouldNotReturnSeparators() {
        Assert.assertFalse(DefaultParser.parse(ParseContentStub.getContent()).contains("ç"));
    }

    @Test
    public void shouldReturnTreeLines() {
        Assert.assertTrue(DefaultParser.parse(ParseContentStub.getContent()).get(0).size() == 3);
    }
}