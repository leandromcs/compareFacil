package br.com.cp.comparefacilrest.service.impl;

import br.com.cp.comparefacilrest.dto.PessoaDTO;
import br.com.cp.comparefacilrest.model.AtivoEnum;
import br.com.cp.comparefacilrest.model.Pessoa;
import br.com.cp.comparefacilrest.repository.PessoaRepository;
import br.com.cp.comparefacilrest.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;

@Service
@PropertySource("classpath:/application.properties")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

//    @Autowired
//    private JavaMailSender javaMailSender;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Pessoa save(PessoaDTO dto) throws BadRequestException {

        Pessoa pessoa = new Pessoa();

        try {
            if (!(pessoaRepository.findByEmail(dto.getEmail()).isPresent())) {
                pessoa.setCpf(dto.getCpf());
                pessoa.setNome(dto.getNome());
                pessoa.setEmail(dto.getEmail());
                pessoa.setPassword(dto.getPassword());
                pessoa.setDataNascimento(dto.getDataNascimento());
                pessoa.setAtivo(dto.getAtivo());
                pessoa.setCargo(dto.getCargo());
                pessoa.setUltimoAcesso(dto.getUltimoAcesso());
                return pessoaRepository.save(pessoa);
            }
        } catch (BadRequestException b) {
            return null;
        }

        return null;
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa findPessoaByEmail(String email) { return pessoaRepository.findByEmail(email).get();}

    @Override
    public List<Pessoa> getPessoasAtivas() {
        return this.pessoaRepository.getPessoasAtivas();
    }

    @Override
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Pessoa update(PessoaDTO dto) {
        Optional<Pessoa> consultado = this.pessoaRepository.findById(dto.getId());

        Pessoa pessoa = consultado.get();
        pessoa.setCpf(dto.getCpf());
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setPassword(dto.getPassword());
        pessoa.setDataNascimento(dto.getDataNascimento());
        pessoa.setCargo(dto.getCargo());
        pessoa.setUltimoAcesso(dto.getUltimoAcesso());

        pessoa = pessoaRepository.save(pessoa);

       // this.sendMail(pessoa);

        return pessoa;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Optional<Pessoa> consultado = this.pessoaRepository.findById(id);
        Pessoa pessoa = consultado.get();
        pessoa.setAtivo(AtivoEnum.INATIVO);
        pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa login(String email, String password) {
        Pessoa login = pessoaRepository.login(email, password);
        if (login != null) {
            return login;
        } else {
            return null;
        }
    }


//    private void sendMail(Pessoa pessoa) {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//
//        simpleMailMessage.setFrom("homeprojectfamily@gmail.com");
//        simpleMailMessage.setTo(pessoa.getEmail());
//        simpleMailMessage.setSubject("Cadastro efetuado");
//        simpleMailMessage.setText("Seja bem vindo ao sistema Compare Fácil" + pessoa.getNome() + ", estamos felizes em ter você aqui !");
//
//        javaMailSender.send(simpleMailMessage);
//
//
//    }


}
