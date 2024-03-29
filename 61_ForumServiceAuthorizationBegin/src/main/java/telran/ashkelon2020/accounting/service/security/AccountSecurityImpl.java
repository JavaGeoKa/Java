package telran.ashkelon2020.accounting.service.security;

import java.time.LocalDateTime;
import java.util.Base64;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2020.accounting.dao.UserAccountRepository;
import telran.ashkelon2020.accounting.dto.UserLoginDto;
import telran.ashkelon2020.accounting.dto.exceptions.ForbiddenException;
import telran.ashkelon2020.accounting.dto.exceptions.UnauthorizedException;
import telran.ashkelon2020.accounting.dto.exceptions.UserNotFoundException;
import telran.ashkelon2020.accounting.model.UserAccount;

@Service
public class AccountSecurityImpl implements AccountSecurity {

	@Autowired
	UserAccountRepository repository;

	@Override
	public String getLogin(String token) {
		UserLoginDto userLoginDto = tokenDecode(token);     //достает из токена userLoginDto
		UserAccount userAccount = repository.findById(userLoginDto.getLogin())  //возвращает userAccount
				.orElseThrow(() -> new UserNotFoundException(userLoginDto.getLogin()));  //или бросаем исключение
		if (!BCrypt.checkpw(userLoginDto.getPassword(), userAccount.getPassword())) {  //проверяем совпадениие пароля
			throw new UnauthorizedException();    // если не совпало бросаем исключение
		}	
		// FIXME check roles
//		проверяем роль
		
		
		
		return userAccount.getLogin();
	}

	@Override
	public boolean checkExpDate(String login) {
		UserAccount userAccount = repository.findById(login)
				.orElseThrow(() -> new UserNotFoundException(login));
		if (userAccount.getExpDate().isBefore(LocalDateTime.now())) {
			throw new ForbiddenException();
		}
		return true;
	}

	private UserLoginDto tokenDecode(String token) {
		try {
			String[] credentials = token.split(" ");
			String credential = new String(Base64.getDecoder().decode(credentials[1]));
			credentials = credential.split(":");
			return new UserLoginDto(credentials[0], credentials[1]);
		} catch (Exception e) {
			throw new UnauthorizedException();
		}
	}

}
