interface Props extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  icon?: React.ReactNode;
}

export function Boton({ children, icon, ...props }: Props) {
  return (
    <button
      className="flex items-center justify-center p-2 mr-7 bg-orange-500 text-black 
      rounded-lg hover:bg-orange-300 focus:outline-none focus:ring-2 focus:ring-orange-300 
      focus:ring-opacity-75 font-extrabold"
      {...props}
    >
      {icon && <span className=" w-35 h-25 mr-2">{icon}</span>}
      {children}
    </button>
  );
}

export default Boton;
    
