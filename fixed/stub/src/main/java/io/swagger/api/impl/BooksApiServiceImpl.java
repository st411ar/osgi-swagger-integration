package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Book;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-07-25T13:30:53.545+03:00")
public class BooksApiServiceImpl extends BooksApiService {
    @Override
    public Response addBook(Integer id, String title, Integer authorId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        return Response.ok().entity(Util.addBook(id, title, authorId)).build();
    }
    @Override
    public Response getBook(Integer id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        return Response.ok().entity(Util.getBook(id)).build();
    }
    @Override
    public Response getBooks(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        return Response.ok().entity(Util.getBooks()).build();
    }
}
