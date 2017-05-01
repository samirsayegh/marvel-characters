package com.samirsayegh.marvelchars.model.entities;

import com.samirsayegh.marvelchars.domain.entities.BaseContent;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */
public class BaseContentTest {

    private static BaseContent baseContent;

    @BeforeClass
    public static void beforeClass() {
        baseContent = new BaseContent();
    }

    @Test
    public void getName() throws Exception {
        testName();
    }

    @Test
    public void setName() throws Exception {
        testName();
    }

    private void testName() {
        String ironMan = "IRON_MAN";
        baseContent.setName(ironMan);
        Assert.assertNotNull(baseContent.getName());
        Assert.assertEquals(ironMan, baseContent.getName());
        Assert.assertNotSame("I-MAN", baseContent.getName());
        baseContent.setName(null);
        Assert.assertNull(baseContent.getName());
    }

    @Test
    public void getDescription() throws Exception {
        testDescription();
    }

    @Test
    public void setDescription() throws Exception {
        testDescription();
    }

    private void testDescription() {
        String ironManDescription = "IRON_MAN_DESCRIPTION";
        baseContent.setDescription(ironManDescription);
        Assert.assertNotNull(baseContent.getDescription());
        Assert.assertEquals(ironManDescription, baseContent.getDescription());
        Assert.assertNotSame("I-MAN", baseContent.getDescription());
        baseContent.setDescription(null);
        Assert.assertNull(baseContent.getDescription());
    }

    @Test
    public void getThumbnailPath() throws Exception {
        testThumbnail();
    }

    @Test
    public void setThumbnailPath() throws Exception {
        testThumbnail();
    }

    private void testThumbnail() {
       /* String thumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec";
        baseContent.setThumbnailPath(thumbnail);
        Assert.assertNotNull(baseContent.getThumbnailPath());
        Assert.assertEquals(thumbnail, baseContent.getThumbnailPath());
        Assert.assertNotSame("http://6/20/52602f21f29eca", baseContent.getThumbnailPath());
        baseContent.setThumbnailPath(null);
        Assert.assertNull(baseContent.getThumbnailPath());*/
    }

}