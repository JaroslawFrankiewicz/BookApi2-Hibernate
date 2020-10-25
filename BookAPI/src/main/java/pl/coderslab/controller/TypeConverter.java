package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Type;
import pl.coderslab.repository.BookRepository;

import java.util.List;

public class TypeConverter implements Converter<String, List<Type>> {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Type> convert(String type) {
        return bookRepository.findByType(type(type));
    }

    private String type(String type) {
        return type;
    }
}