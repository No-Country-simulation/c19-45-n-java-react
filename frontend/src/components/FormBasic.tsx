import { Input, InputPassword } from ".";

export const FormBasic = () => {
  return (
    <>
      <Input
        label="Nombres completos*"
        type="text"
        placeholder="Ingresar nombres"
      />
      <Input
        label="Correo electrónico*"
        type="email"
        placeholder="Ingresar correo"
      />
      <InputPassword label="Contraseña*" placeholder="Ingrese su contraseña" />
      <InputPassword
        label="Confirmar Contraseña*"
        placeholder="Ingrese nuevamente su contraseña"
      />
    </>
  );
};
