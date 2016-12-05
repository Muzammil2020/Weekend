#include <iostream>
#include <stdlib.h>
using namespace std;
int Map2Dto1D(int ri, int ci, int Dim)
{
    return (ri-1)*Dim+ci-1;
}
void InitBoard(char B[3][3] , int Dim)
{
    for(int ri=0; ri<Dim; ri++)
    {
        for(int ci=0; ci<Dim; ci++)
        {
            //int index = Map2Dto1D(ri,ci,Dim);
            B[ri][ci]=' ';
        }
    }
}
void PrintBoard(char B[3][3], int Dim)
{
    system("cls");
    cout<<"\n\n\n\n";
    for(int ri=0; ri<Dim; ri++)
    {
        cout<<"\t\t\t\t";
        for(int ci=0; ci<Dim; ci++)
        {
            //int index = Map2Dto1D(ri,ci,Dim);
            cout<< B[ri][ci];
            if(ci!=Dim-1)
                cout<<char(-80);
        }

        cout<<endl;

        if(ri!=Dim-1)
        {
            cout<<"\t\t\t\t";
            cout<<char(-80)<<char(-80)<<char(-80)<<char(-80)<<char(-80)<<endl;
        }
    }
}

void TakeInput(int & ri, int & ci, int Dim)
{
    cout<<"Enter Your Coordinates (0-"<<Dim-1<<") :";
    cin>>ri >> ci;
}


void WriteOnBoard(char B[3][3], int ri, int ci, int Dim, char Turn)
{
    //int index = Map2Dto1D(ri,ci,Dim);
    B[ri][ci]=Turn;
}

void TurnChange(char &Turn)
{
    if(Turn=='X')
        Turn='O';
    else
        Turn='X';
}

bool CheckLegality(char B[3][3], int ri, int ci, int Dim)
{
    if(ri<0 || ci<0 || ri>Dim-1 || ci>Dim-1)
        return false;
    //int index = Map2Dto1D(ri,ci,Dim);
    if(B[ri][ci]!=' ')
    {
        return false;
    }

    return true;
}

bool IsDraw(char B[3][3], int Dim)
{
    for(int ri=0; ri<Dim; ri++)
    {

        for(int ci=0; ci<Dim; ci++)
        {
      //      int index = Map2Dto1D(ri,ci,Dim);
            if(B[ri][ci] == ' ')
            {
                return false;
            }
        }
    }

    return true;
}
bool IsWin(char B[3][3], int Dim, char Turn)
{
    for(int ri=0; ri<Dim; ri++)
    {
        int count=0;
        for(int ci=0; ci<Dim; ci++)
        {
        //    int index = Map2Dto1D(ri,ci,Dim);
            if( B[ri][ci]==Turn)
                count++;
        }
        if(count==3)
        {
            return true;
        }
    }
    for(int ci=0; ci<Dim; ci++)
    {
        int count=0;
        for(int ri=0; ri<Dim; ri++)
        {
          //  int index = Map2Dto1D(ri,ci,Dim);
            if( B[ri][ci]==Turn)
                count++;
        }
        if(count==3)
        {
            return true;
        }
    }

    int ri=0;
    int count=0;
    for(int ci=0; ci<Dim; ci++)
    {
        //int index = Map2Dto1D(ri,ci,Dim);
        if( B[ri][ci]==Turn)
        {
            count++;
        }

        ri++;
        if(count==3)
        {
            return true;
        }
    }
    int ci=Dim-1;
    int c=0;
    for(int ri=0; ri<Dim; ri++)
    {
        //int index = Map2Dto1D(ri,ci,Dim);
        if( B[ri][ci]==Turn)
        {
            c++;
        }

        ci--;
        if(c==3)
        {
            return true;
        }
    }
    return false;
}

int Computer_Input(char Board[3][3], char Turn,int & ri, int & ci, int Dim)
{
    //copying Board in tempBoard
    char temp_Board[3][3];
    int emptyBoard=0;
    for(int i=0; i<Dim; i++){
        for(int j=0; j<Dim; j++){
            temp_Board[i][j]=Board[i][j];
            if(Board[i][j]==' ')
            {
                emptyBoard++;
            }
        }
    }

    if(Turn='O')
    {


        if(emptyBoard==9) // Is the first move is for AI
        {
            ri=rand()%3;
            ci=rand()%3;
            return 0;
        }

        for(int i=0; i<Dim; i++)
        {
            for(int j=0; j<Dim; j++)
            {
                if(Board[i][j]==' ')
                {
                    // AI move if other player is going to win in his/her next move
                    temp_Board[i][j]='X';
                    TurnChange(Turn);
                    if(IsWin(temp_Board, Dim, Turn )==true){
                            ri=i;
                            ci=j;
                            return 0;
                    }
                    else
                    {
                        temp_Board[i][j]=' ';
                    }
                    TurnChange(Turn);

                    // Checking AI win or not
                    temp_Board[i][j]='O';
                    if(IsWin(temp_Board, Dim, Turn )==true){
                        ri=i;
                        ci=j;
                        return 0;
                    }
                    else
                    {
                        temp_Board[i][j]=' ';
                    }
                }

            }
        }

        // AI move if other player is not going to Win in next move

        for(int i=0; i<Dim; i++)
        {
            for(int j=0; j<Dim; j++)
            {
                temp_Board[i][j]='O';
                    for(int x=0; x<Dim; x++)
                    {
                        for(int y=0; y<Dim; y++)
                        {
                            if(temp_Board[x][y]==' ')
                            {
                                temp_Board[x][y]='O';
                                if(IsWin(temp_Board, Dim, Turn )==true){
                                    ri=x;
                                    ci=y;
                                    temp_Board[x][y]=' ';
                                    return 0;
                                }
                            }
                        }
                    }
                    temp_Board[i][j]=' ';
                    if(IsWin(temp_Board, Dim, Turn )==true){
                            ri=i;
                            ci=j;
                            return 0;
                    }
            }
        }
    }
}


int main()
{
    int nGames=0;
    int Dim = 3;
    int ri, ci;
    char Turn='O';
    char Board[3][3];
    InitBoard(Board, Dim);
    bool Won = false;

    do
    {
        PrintBoard(Board, Dim);
        do
        {

            if(Turn=='X')
            {
                TakeInput(ri, ci, Dim);
            }
            else
            {

              Computer_Input(Board, Turn, ri, ci, Dim);
            }
        }
        while(CheckLegality(Board, ri, ci, Dim)==false);

        WriteOnBoard(Board, ri, ci, Dim, Turn);

        if(IsWin(Board, Dim, Turn)==false)
        {
            TurnChange(Turn);
        }
        else
        {
            Won = true;
        }
    }
    while(IsDraw(Board, Dim)==false && Won == false );
    PrintBoard(Board, Dim);


    if(Won)
    {
        cout<<"Player "<<Turn<<" has Won...!"<<endl;
    }
    else
    {
        cout<<"Game Drawn"<<endl;
    }
    return 0;
}
