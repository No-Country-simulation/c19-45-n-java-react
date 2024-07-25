interface Props extends React.ButtonHTMLAttributes<HTMLButtonElement> {}

export function Button({ children, ...props }: Props) {
  return (
    <button
    className="btn btn-primary bg-black text-xl m-3 hover:bg-gray-600 w-52 border-transparent"
      {...props}
    >
      {children}
    </button>
  );
}

export default Button;
