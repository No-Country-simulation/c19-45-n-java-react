interface IContact {
  names: string;
  email: string;
}

interface IContactItem {
  title: string;
  text: string;
}
const ContactItem = ({ title, text }: IContactItem) => {
  return (
    <div className="flex flex-col gap-1">
      <p className="text-2xl font-bold">{title}</p>
      <p className="text-xl">{text}</p>
    </div>
  );
};

export const Contact = () => {
  return (
    <section className="bg-[#FFCD82] p-10 rounded-lg shadow-l">
      <h1 className="font-bold text-3xl">Datos de Contacto:</h1>
      <div className="grid grid-cols-2 ml-4 mt-4">
        <ContactItem title="Nombres completos" text="Nataly" />
        <ContactItem
          title="Correo Electrónico"
          text="natalyrojasm5@gmail.com"
        />
      </div>
    </section>
  );
};
