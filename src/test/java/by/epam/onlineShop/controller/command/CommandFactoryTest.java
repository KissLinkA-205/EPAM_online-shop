package by.epam.onlineShop.controller.command;

import by.epam.onlineShop.controller.command.impl.*;
import by.epam.onlineShop.controller.command.impl.transition.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandFactoryTest {

    @Test
    public void testCreateCommand_ShouldReturnAddToBasketCommand_WhenCommandIsAddToBasket() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.ADD_TO_BASKET_COMMAND);
        assertEquals(actual.getClass(), AddToBasketCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnCompleteOrderCommand_WhenCommandIsCompleteUserOrder() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.COMPLETE_USER_ORDER_COMMAND);
        assertEquals(actual.getClass(), CompleteOrderCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnConfirmAddingProductCommand_WhenCommandIsConfirmAddingProduct() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.CONFIRM_ADDING_PRODUCT_COMMAND);
        assertEquals(actual.getClass(), ConfirmAddingProductCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnConfirmAddingPromotionCommand_WhenCommandIsConfirmAddingPromotion() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.CONFIRM_ADDING_PROMOTION_COMMAND);
        assertEquals(actual.getClass(), ConfirmAddingPromotionCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnConfirmOrderCommand_WhenCommandIsConfirmOrder() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.CONFIRM_ORDER_COMMAND);
        assertEquals(actual.getClass(), ConfirmOrderCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnConfirmProductChangeCommand_WhenCommandIsConfirmProductChange() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.CONFIRM_EDIT_PRODUCT);
        assertEquals(actual.getClass(), ConfirmProductChangeCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnDeleteOrderCommand_WhenCommandIsDeleteOrder() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.DELETE_ORDER_COMMAND);
        assertEquals(actual.getClass(), DeleteOrderCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnDeleteUserOrderCommand_WhenCommandIsDeleteUserOrder() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.DELETE_USER_ORDER_COMMAND);
        assertEquals(actual.getClass(), DeleteUserOrderCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnLogInCommand_WhenCommandIsCheckLogin() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.CHECK_LOGIN_COMMAND);
        assertEquals(actual.getClass(), LogInCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnLogOutCommand_WhenCommandIsLogOut() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.LOG_OUT_COMMAND);
        assertEquals(actual.getClass(), LogOutCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnLogUpCommand_WhenCommandIsRegistration() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.REGISTRATION_COMMAND);
        assertEquals(actual.getClass(), LogUpCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToAddOrderCommand_WhenCommandIsAddOrder() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.ADD_ORDER_COMMAND);
        assertEquals(actual.getClass(), GoToAddOrderCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToAddProductCommand_WhenCommandIsAddProduct() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.ADD_PRODUCT_COMMAND);
        assertEquals(actual.getClass(), GoToAddProductCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToAddPromotionCommand_WhenCommandIsAddPromotion() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.ADD_PROMOTION_COMMAND);
        assertEquals(actual.getClass(), GoToAddPromotionCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToBasketCommand_WhenCommandIsBasket() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.BASKET_COMMAND);
        assertEquals(actual.getClass(), GoToBasketCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToCatalogCommand_WhenCommandIsCatalog() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.CATALOG_COMMAND);
        assertEquals(actual.getClass(), GoToCatalogCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToContactsCommand_WhenCommandIsContacts() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.CONTACTS_COMMAND);
        assertEquals(actual.getClass(), GoToContactsCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToEditProductCommand_WhenCommandIsEditProduct() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.EDIT_PRODUCT_COMMAND);
        assertEquals(actual.getClass(), GoToEditProductCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToLogInCommand_WhenCommandIsLogIn() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.LOG_IN_COMMAND);
        assertEquals(actual.getClass(), GoToLogInCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToLogUpCommand_WhenCommandIsLogUp() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.LOG_UP_COMMAND);
        assertEquals(actual.getClass(), GoToLogUpCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToMainCommand_WhenCommandIsMain() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.MAIN_COMMAND);
        assertEquals(actual.getClass(), GoToMainCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToMyOrdersCommand_WhenCommandIsMyOrders() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.MY_ORDERS_COMMAND);
        assertEquals(actual.getClass(), GoToMyOrdersCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToProfileCommand_WhenCommandIsProfile() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.PROFILE_COMMAND);
        assertEquals(actual.getClass(), GoToProfileCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToPromotionsCommand_WhenCommandIsPromotions() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.PROMOTIONS_COMMAND);
        assertEquals(actual.getClass(), GoToPromotionsCommand.class);
    }

    @Test
    public void testCreateCommand_ShouldReturnGoToViewOrdersCommand_WhenCommandIsViewOrders() {
        Command actual = CommandFactory.getInstance().getCommand(CommandName.VIEW_ORDERS_COMMAND);
        assertEquals(actual.getClass(), GoToViewOrdersCommand.class);
    }
}