package de.ait.gp.controllers;

import de.ait.gp.controllers.api.UsersApi;
import de.ait.gp.dto.kindergarten.*;
import de.ait.gp.dto.user.NewUserDto;
import de.ait.gp.dto.user.UpdateUserDto;
import de.ait.gp.dto.user.UserDto;
import de.ait.gp.secutity.details.AuthenticatedUser;
import de.ait.gp.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserControllers implements UsersApi {
    private final UsersService usersService;

    @Override
    public UserDto register(NewUserDto newUser){
        return usersService.register(newUser);
    }

    @Override
    public UserDto getProfile(AuthenticatedUser user){
        Long currentId = user.getId();
        return usersService.getProfile(currentId);
    }

    @Override
    public UserDto confirm(String code) {
        return usersService.confirm(code);
    }

    @Override
    public KindergartenDto addControlKindergartenToManager(AuthenticatedUser user, NewKindergartenDto newKindergarten) {
        return usersService.addControlKindergartenToManager(user.getId(), newKindergarten);
    }

    @Override
    public KindergartenDto getControlKindergarten(AuthenticatedUser user) {
        return usersService.getControlKindergarten(user.getId());
    }

    @Override
    public UserDto updateUser(AuthenticatedUser user, UpdateUserDto updateUserDto) {
        return usersService.updateUser(user.getId(), updateUserDto);
    }

    @Override
    public KindergartenDto updateControlKindergarten(AuthenticatedUser user, UpdateKindergartenDto updateKindergartenDto) {
        return usersService.updateControlKindergarten(user.getId(), updateKindergartenDto);
    }

    @Override
    public KindergartenDtoList getFavoriteKindergartens(AuthenticatedUser user) {
        return usersService.getAllFavoriteKindergartens(user.getId());
    }

    @Override
    public KindergartenDto addKindergartenToFavorites(AuthenticatedUser user, KindergartenToFavoriteDto kindergartenToFavoriteDto) {
        return usersService.addKindergartenToFavorites(user.getId(), kindergartenToFavoriteDto.getKindergartenId());
    }

    @Override
    public KindergartenDtoList getAllChildren(AuthenticatedUser user) {
        return null;
    }

    @Override
    public KindergartenDto deleteKindergartenFromFavorites(AuthenticatedUser user, KindergartenToFavoriteDto kindergartenFromFavorite) {
        return usersService.deleteKindergartenFromFavorites(user.getId(),kindergartenFromFavorite.getKindergartenId());
    }
}
