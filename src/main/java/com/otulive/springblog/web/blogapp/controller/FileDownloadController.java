/**
 * Created on Dec 15, 2011
 */
package com.otulive.springblog.web.blogapp.controller;

import com.otulive.springblog.domain.CommentAttachment;
import com.otulive.springblog.domain.EntryAttachment;
import com.otulive.springblog.service.CommentAttachmentService;
import com.otulive.springblog.service.EntryAttachmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by roger on 14-2-23.
 */
@RequestMapping("/blogs/filedownload")
@Controller
public class FileDownloadController {

  final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);

  @Autowired
  private EntryAttachmentService entryAttachmentService;

  @Autowired
  private CommentAttachmentService commentAttachmentService;

  @RequestMapping(value = "/entry/{id}", method = RequestMethod.GET,
                  produces = "application/force-download")
  @ResponseBody
  public byte[] downloadEntryAttachment(@PathVariable("id") Long id, HttpServletRequest request,
                                        HttpServletResponse response) {
    logger.info("Processing download for entry attachment with id {}", id);

    EntryAttachment attachment = entryAttachmentService.findById(id);

    response.setContentType(attachment.getContentType());
    response.setContentLength(attachment.getFileData().length);
    response.setHeader("Content-Disposition",
                       "attachment; filename=\"" + attachment.getFileName() + "\"");

    return attachment.getFileData();
  }

  @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET,
                  produces = "application/force-download")
  @ResponseBody
  public byte[] downloadCommentAttachment(@PathVariable("id") Long id, HttpServletRequest request,
                                          HttpServletResponse response) {
    logger.info("Processing download for comment attachment with id {}", id);

    CommentAttachment attachment = commentAttachmentService.findById(id);

    response.setContentType(attachment.getContentType());
    response.setContentLength(attachment.getFileData().length);
    response.setHeader("Content-Disposition",
                       "attachment; filename=\"" + attachment.getFileName() + "\"");

    return attachment.getFileData();
  }

}
