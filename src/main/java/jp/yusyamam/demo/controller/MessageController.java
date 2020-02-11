package jp.yusyamam.demo.controller;

import jp.yusyamam.demo.mapper.MessageMapper;
import jp.yusyamam.demo.repository.MessageRepository;
import jp.yusyamam.demo.view.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("messages")
public class MessageController {
// Mybatisを利用する場合
    @Autowired
    MessageMapper messageMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getMessages() {
        return messageMapper.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Message postMethod(@RequestBody Message message) {
        messageMapper.create(message);
        return message;
    }


//    Spring JPAを利用する場合
//    @Autowired
//    MessageRepository messageRepository;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Message> getMessage() {
//        return messageRepository.findAll();
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Message postMessage(@RequestBody Message message) {
//        return messageRepository.save(message);
//    }

//    Spring JDBCを利用する場合
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Message> getMessages() {
//        return jdbcTemplate.query("SELECT text FROM messages ORDER BY id", (rs, i) -> {
//            Message m = new Message();
//            m.setText((rs.getString("text")));
//            return m;
//        });
//    }
//
//    // curl -v -H "Content-type: application/json" -X POST -d "{\"text\":\"yusyamam\"}" http://localhost:8080/messages
//    @RequestMapping(method = RequestMethod.POST)
//    public Message postMessages(@RequestBody Message message) {
//        jdbcTemplate.update("INSERT INTO messages(text) VALUES (?)", message.getText());
//        return message;
//    }


//    データベースを利用しない場合
//    final List<Message> messages = new CopyOnWriteArrayList<>();
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Message postMessage(@RequestBody Message message) {
//        messages.add(message);
//        return message;
//    }
}
