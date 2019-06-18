#include <stdio.h>
#include <stdlib.h>
#include<string.h>
#include<conio.h>
#include<windows.h>
void delay()
{
    int time1,time2;
    for(time1=1;time1<=25000;time1++)
    for(time2=1;time2<=25000;time2++);
}
int TotalBook=0,OrgTotalBook; //TotalBook has number of books.
struct library
{
    int BookAccessionNO,BookCount,OrginialCount; //BookAccessionNo holds the unique book id generated in runtime, BookCount has the number of books
    char BookName[50],BookIdentificationNo[6],BookAuthor[30]; //BookName holds the name of book, BookIdentificationNo has unique book id given by admin, BookAuthor has author name.
    char BookSubject[20],BookDescription[1000];  //BpokSubject has subject of book,BookDescription holds comments about book.
    float BookPrice,BookLocation;  //BookPrice holds price of book,BookLocation has location of book in library
    char UserName,UserNumber;  //UserName has name of user who takes the book and UserNumber holds his contact number
    struct library *next;
}*head,*mover;  //head and mover are struct pointers which always indicate the first book and moves among the books respectively.

void addBook();
void displayBookInformation();
void registerForNotification();
void overDue();
void issueOrReturn();
void displayBookInformationUser();
void deleteBook();
int main()
{
    system("color 2");
    printf("\n\n\n\n\n\n                                   * * * * * * * * * * * * * * * * * * * * * *\n                                   *                                         *\n                                   *   LIBRARY DATABASE MANAGEMENT SYSTEM    *");
    printf("\n                                   *                                         *\n                                   * * * * * * * * * * * * * * * * * * * * * *");
    delay();
    system("cls");
    head=NULL;
      char OldPassword[20],NewPassword1[20],NewPassword2[20];
    char Choice1,Choice2,Choice5;// choice1 FOR person to check if user login or admin login , choice for admin access,c
    int WrongPassword=0;
    long int NotificationMobile;
    char NotificationName[20],FeedBack[1000];
    char PredefinedPassword[20]={"s"}, Password[20]; //predefined password , password get from user for admin login
    do{
    label1:
    system("color 9");
    system("cls");
    printf("\n\n\n\n\n           ***********LIBRARY DATABASE MANAGEMENT SYSTEM************");
    printf("\n                      ----------------------------------");
    printf("\n                      ----------------------------------");
    printf("\n\n                         ENTER USER TYPE");
        printf("\n                             1.ADMIN\n                             2.USER\n\n                         ENTER YOUR OPTION : ");
        scanf(" %c",&Choice1);
        switch(Choice1)
        {
    case '1':
        do
        {
            label2:
            system("cls");
            printf("\n\n\n\n                         *******ADMIN LOGIN*******");
            printf("\n\n                         ENTER ADMIN PASSWORD : ");
            scanf("%s",Password);
            if(!strcmp(Password,PredefinedPassword))  //Compares Password and Predefined Password
            {
                WrongPassword=0;
                while(1)
                {
                    system("color 3");
                    system("cls");
                     printf("\n\n\n\n                         *******ADMIN LOGIN*******\n");
                    printf("\n                         1.ADD A BOOK\n                         2.DISPLAY A BOOK INFORMATION\n                         3.ISSUE / RETURN\n                         4.OVERDUE\n                         5.ADMIN SETTINGS\n                         6. DELETE A BOOK\n                         7. BACK\n");
                    printf("\n                         SELECT YOUR OPTION : ");
                    scanf("%c",&Choice2);
                   switch(Choice2)
                    {
                    case '1':
                        addBook(); // add a book function
                        break;
                    case '2':
                        displayBookInformation(); //display a book function
                        break;
                    case '3':
                        issueOrReturn(); // issue or return function
                            break;
                    case '4':
                        overDue(); //overdue function to calculate overdue date
                        break;
                    case '5':
                        system("cls");
                        printf("\n\n\n\n                         ADMIN SETTINGS --> CHANGE PASSWORD\n");
                        printf("\n                         ENTER OLD PASSWORD : ");
                        scanf("%s",OldPassword);
                        if(!strcmp(OldPassword,PredefinedPassword))
                        {
                            system("cls");
                          label4:
                            printf("\n                          ***CHANGE PASSWORD***\n");
                            printf("\n                          ENTER NEW PASSWORD : ");
                            scanf("%s",NewPassword1);
                              printf("\n                          REENTER NEW PASSWORD : ");
                            scanf("%s",NewPassword2);
                            if(strcmp(NewPassword1,NewPassword2)==0)
                            {
                                strcpy(PredefinedPassword,NewPassword2);
                                printf("\n\n                        ***PASSWORD HAS BEEN CHANGED SUCCESSFULLY***\n");
                                delay();
                            }
                            else
                            {
                                printf("\n                    ***RE-ENTER PASSWORD***\n");
                                delay();
                                system("cls");
                                goto label4;
                            }

                        }
                        else
                            printf("\n                    ***PASSWORD INCORRECT-UNAUTHORIZED ACCESS***");
                            delay();
                        break;
                    case '6':
                        deleteBook();
                        break;
                    case '7':
                        goto label1; // control moves to label 1

                    default:
                        printf("\n\n                         ***ENTER CORRECT OPTION FOR ADMIN ACCESS***");
                        break;
                    }

                }
            }
            else
            {
                printf("\n\n                         ***ENTER A VALID PASSWORD***");
                printf("\n\n                         You have %d attempt(s) left",2-WrongPassword);
                WrongPassword++;
                delay();
                if(WrongPassword<3)
                    goto label2;
                else
                    goto label1;
            }
        }while(1);

        case '2':
            do
            {
                system("color 5");
                system("cls");
                 printf("\n\n\n\n                           *******USER LOGIN*******");
                printf("\n                         1.DISPLAY BOOK INFORMATION\n                         2.REGISTER FOR NOTIFICATION\n                         3.FEEDBACK\n                         4.BACK\n");
                printf("\n                         ENTER YOUR OPTION : ");
                scanf("%c",&Choice5);
                switch(Choice5)
                {
                case '1':
                    displayBookInformationUser();
                    break;
                case '2':
                    system("cls");
                    printf("\n\n\n\n                       *******REGISTER FOR NOTIFICATION*******\n");
                    printf("\n                       ENTER NAME : ");
                    scanf("%s",NotificationName);
                    printf("\n                       ENTER MOBILE NUMBER : ");
                    scanf("%ld",&NotificationMobile);
                    printf("\n                       ********THANK YOU FOR REGISTRATION..! YOU WILL BE NOTIFIED REGARDING NEW UPDATES**** ");
                    delay();
                    break;
                case '3':
                    system("cls");
                    printf("\n\n\n\n                       *******PROVIDE YOUR VALUBLE FEEDBACK*******\n\n                          ");
                    scanf("%s",FeedBack);
                    printf("\n\n                       THANKS FOR YOUR FEEDBACK....!!!");
                    delay();
                    break;
                case '4':
                    goto label1;
                default:
                    printf("\n                         ENTER CORRECT CHOICE : ");

                }

            }while(1);
            break;
        default :
               printf("\n\n                         ***INVALID OPTION***");
               delay();
               system("cls");
               break;
        }
    }while(1);
        return 0;
}
void addBook()
{
    struct library *newbook;
    int Edit=0;
    char Temp[5];// temporary variable
    newbook=(struct library*)malloc(sizeof(struct library));
    label5:
    system("cls");
    printf("\n\n\n\n                         *******ADD A NEW BOOK*******\n");
    printf("\n                         ENTER THE BOOK DETAILS\n");
    printf("\n                         ENTER BOOK IDENTIFICATION NUMBER : ");
    scanf("%s",newbook->BookIdentificationNo);
    gets(Temp);
    printf("\n                         ENTER BOOK NAME : ");
    gets(newbook->BookName);
    printf("\n                         ENTER BOOK AUTHOR NAME : ");
    gets(newbook->BookAuthor);
    printf("\n                         ENTER BOOK SUBJECT : ");
    gets(newbook->BookSubject);
    printf("\n                         ENTER BOOK DESCRIPTION : ");
    gets(newbook->BookDescription);
    printf("\n                         ENTER BOOK PRICE : ");
    scanf("%f",&newbook->BookPrice);
    printf("\n                         ENTER NUMBER OF BOOKS : ");
    scanf("%d",&newbook->BookCount);
    newbook->OrginialCount=newbook->BookCount;
    printf("\n                         ENTER BOOK LOCATION : ");
    scanf("%f",&newbook->BookLocation);
    printf("\n                         ***PRESS 1 TO CONTINUE TO SAVE***\n\n                         ***PRESS 2 TO REENTER BOOK DETAILS***      ");
    scanf("%d",&Edit);
    if(Edit==1)
    {
    TotalBook++;
    OrgTotalBook++;
    newbook->BookAccessionNO=OrgTotalBook;
    newbook->next=NULL;
    if(head==NULL)
    {
        head=mover=newbook;
    }
    else
    {
        mover = head;
        while(!(mover->next==NULL))
        {
            mover=mover->next;
        }
        mover->next = newbook;
    }
    printf("\n                    *****BOOK REGISTERED SUCCESSFULLY*****\n");
    printf("\n                    *****MESSAGE SENT TO REGISTERED USER*****\n");
    delay();
    }
    else if(Edit ==2)
    {
        goto label5;
    }
    }
void displayBookInformation()
{
    struct library *f;
    int Choice3,SearchCount;  //for selecting option
    char SearchBookName[50],SearchBookAuthor[30],SearchSubject[20],Temp2[2];
    while(1)
    {
    system("cls");
    printf("\n\n\n\n                    ***DISPLAY BOOK INFORMATION***\n");
    printf("\n                    SEARCH VIA\n                      1.NAME\n                      2.AUTHOR NAME\n                      3.SUBJECT\n");
    printf("                    4. DISPLAY ALL BOOKS\n                    5. TOTAL BOOK COUNT\n                    6. BACK\n");
    int BookFoundTrack=0;
    printf("\n                        ENTER YOUR CHOICE : ");
    scanf("%d",&Choice3);
    SearchCount=0;
    switch(Choice3)
    {
    case 1:
        system("cls");
        printf("\n\n\n\n                    *****SEARCH --> BOOK NAME*****");
        printf("\n\n                    ENTER BOOK NAME : ");
        f=head;
        gets(Temp2);
        gets(SearchBookName);
     while(SearchCount<TotalBook)
        {
            if(strcmp(f->BookName,SearchBookName)==0)
            {
                BookFoundTrack=1;
                printf("\n\n                           ***BOOK FOUND***\n\n");
                printf("                    BOOK ACCESSION NUMBER : %d\n                    BOOK IDENTIFICATION NUMBER : %s\n",f->BookAccessionNO,f->BookIdentificationNo);
                printf("                    BOOK NAME : %s\n                    BOOK AUTHOR NAME : %s\n",f->BookName,f->BookAuthor);
                printf("                    BOOK SUBJECT : %s\n                    BOOK DESCRIPTION : %s\n",f->BookSubject,f->BookDescription);
                printf("                    BOOK PRICE : %.2f\n                    BOOK COUNT : %d\n",f->BookPrice,f->BookCount);
                printf("                    BOOK LOCATION : %.2f\n",f->BookLocation);
                if(f->BookCount>0)
                                    printf("                    BOOK STATUS : AVAILABLE\n");
                else
                    printf("                    BOOK STATUS : NOT AVAILABLE\n");
            }
            f=f->next;
            SearchCount++;
        }
           if(BookFoundTrack!=1)
            printf("\n\n                    SORRY !!! BOOK NOT FOUND\n");
            getch();
        break;
    case 2:
        system("cls");
        printf("\n\n\n\n                    *****SEARCH --> BOOK AUTHOR NAME*****");
        printf("\n\n                    ENTER AUTHOR NAME : ");
        f=head;
        gets(Temp2);
        gets(SearchBookAuthor);
     while(SearchCount<TotalBook)
        {
            if(strcmp(f->BookAuthor,SearchBookAuthor)==0)
            {
                BookFoundTrack=1;
                printf("\n\n                           ***BOOK FOUND***\n\n");
                printf("                    BOOK ACCESSION NUMBER : %d\n                    BOOK IDENTIFICATION NUMBER : %s\n",f->BookAccessionNO,f->BookIdentificationNo);
                printf("                    BOOK NAME : %s\n                    BOOK AUTHOR NAME : %s\n",f->BookName,f->BookAuthor);
                printf("                    BOOK SUBJECT : %s\n                    BOOK DESCRIPTION : %s\n",f->BookSubject,f->BookDescription);
                printf("                    BOOK PRICE : %.2f\n                    BOOK COUNT : %d\n",f->BookPrice,f->BookCount);
                printf("                    BOOK LOCATION : %.2f\n",f->BookLocation);
                if(f->BookCount>0)
                                    printf("                    BOOK STATUS : AVAILABLE\n");
                else
                    printf("                    BOOK STATUS : NOT AVAILABLE\n");

            }
            f=f->next;
            SearchCount++;
        }
           if(BookFoundTrack!=1)
            printf("\n\n                    SORRY !!! BOOK NOT FOUND\n");
            getch();
        break;
    case 3:
         system("cls");
        printf("\n\n\n\n                    *****SEARCH --> SUBJECT NAME*****");
        printf("\n\n                    ENTER SUBJECT NAME : ");
        f=head;
        gets(Temp2);
        gets(SearchSubject);
     while(SearchCount<TotalBook)
        {
            if(strcmp(f->BookSubject,SearchSubject)==0)
            {
                BookFoundTrack=1;
                printf("\n\n                           ***BOOK FOUND***\n\n");
                printf("                    BOOK ACCESSION NUMBER : %d\n                    BOOK IDENTIFICATION NUMBER : %s\n",f->BookAccessionNO,f->BookIdentificationNo);
                printf("                    BOOK NAME : %s\n                    BOOK AUTHOR NAME : %s\n",f->BookName,f->BookAuthor);
                printf("                    BOOK SUBJECT : %s\n                    BOOK DESCRIPTION : %s\n",f->BookSubject,f->BookDescription);
                printf("                    BOOK PRICE : %.2f\n                    BOOK COUNT : %d\n",f->BookPrice,f->BookCount);
                printf("                    BOOK LOCATION : %.2f\n",f->BookLocation);
                if(f->BookCount>0)
                                    printf("                    BOOK STATUS : AVAILABLE\n");
                else
                    printf("                    BOOK STATUS : NOT AVAILABLE\n");

            }
            f=f->next;
            SearchCount++;
        }
           if(BookFoundTrack!=1)
            printf("\n\n                    SORRY !!! BOOK NOT FOUND\n");
            getch();
        break;
    case 4:
         system("cls");
        printf("\n\n\n\n                    *****ALL BOOKS*****\n");
         f=head;
         while(SearchCount<TotalBook)
         {
             printf("\n                    %d . %s",f->BookAccessionNO,f->BookName);
             f=f->next;
             SearchCount++;
         }
         getch();
         break;
    case 5:
        printf("\n\n\n\n                    TOTAL BOOK COUNT : %d",TotalBook);
        getch();
        break;
    case 6:
        return;
    default :
        printf("\n                    INVALID OPTION");
        delay();
        system("cls");
        break;
    }
}
}

void issueOrReturn()
{
    struct library *ior;
    int IrCount,IrTrack;
    char BookId[6];
    while(1)
    {
    ior=head;
    system("cls");
    printf("\n\n\n\n                   *****ISSUE / RETURN BOOK*****\n");
    printf("\n                    1. ISSUE\n                    2. RETURN\n                    3. DISPLAY ISSUED BOOKS\n                    4. BACK\n");
    int Choice4;
    printf("\n                    ENTER YOUR CHOICE : ");
    scanf("%d",&Choice4);
    IrCount=0;
    IrTrack=0;
    switch(Choice4)
    {
    case 1:
         system("cls");
        printf("\n\n\n\n                    *****ISSUE*****\n");
      printf("\n                    ENTER BOOK IDENTIFICATION NUMBER : ");
      scanf("%s",BookId);
      while(IrCount<TotalBook)
      {
        if(strcmp(ior->BookIdentificationNo,BookId)==0)
        {
            if(ior->BookCount>0){
            IrTrack=1;
            ior->BookCount--;
            printf("\n                    ***BOOK ISSUED SUCCESSFULLY***\n");
            getch();
            break;
            }
        }
        ior=ior->next;
        IrCount++;
      }
      if(IrTrack!=1)
      {
         printf("\n\n                    ***SORRY !!! BOOK NOT FOUND OR NOT AVAILABLE***\n");
         getch();
         break;
      }
      break;
    case 2:
         system("cls");
        printf("n\n\n\n                    *****RETURN*****\n");
        printf("\n                    ENTER BOOK IDENTIFICATION NUMBER : ");
      scanf("%s",BookId);
      while(IrCount<TotalBook)
      {
        if(strcmp(ior->BookIdentificationNo,BookId)==0)
        {
            if(ior->OrginialCount>ior->BookCount){
            IrTrack=1;
            ior->BookCount++;
            printf("\n                    ***BOOK RETURNED***\n");
            getch();
            break;
            }
        }
        ior=ior->next;
        IrCount++;
      }
      if(IrTrack!=1)
      {
         printf("\n\n                    ***SORRY !!! BOOK NOT FOUND OR WRONG ENTRY***\n");
         getch();
         break;
      }
      break;
    case 3:
        while(IrCount<TotalBook)
        {
            if(ior->OrginialCount>ior->BookCount)
            {
                IrTrack=1;
                printf("\n                    %d . %s",ior->BookAccessionNO,ior->BookName);
            }
            IrCount++;
            ior=ior->next;
        }
        if(IrTrack!=1)
      {
         printf("\n\n                    ***NO BOOK HAS BEEN ISSUED***\n");
         getch();
      }
      getch();
      break;
    case 4:
        return;
    default:
            printf("\n\n                    ***ENTER A VALID OPTION***\n");
            break;
    }
    }
}

void displayBookInformationUser()
{
    struct library *f;
    int Choice3,SearchCount2;  //for selecting option
    char SearchBookName[50],SearchBookAuthor[30],SearchSubject[20],Temp3[2];
    while(1)
    {
     system("cls");
    printf("\n\n\n\n                    ******DISPLAY BOOK INFORMATION*****\n");
    printf("\n                    SEARCH VIA\n                      1.NAME\n                      2.AUTHOR NAME\n                      3.SUBJECT\n");
    printf("                    4. DISPLAY ALL BOOKS\n                    5. BACK\n");
    int BookFoundTrack=0;
    printf("\n                        ENTER YOUR CHOICE : ");
    scanf("%d",&Choice3);
    SearchCount2=0;
    switch(Choice3)
    {
    case 1:
         system("cls");
        printf("\n\n\n\n                    *****SEARCH --> BOOK NAME*****");
        printf("\n\n                    ENTER BOOK NAME : ");
        f=head;
        gets(Temp3);
        gets(SearchBookName);
     while(SearchCount2<TotalBook)
        {
            if(strcmp(f->BookName,SearchBookName)==0)
            {
                BookFoundTrack=1;
                printf("\n\n                    ***BOOK FOUND***\n\n");
                printf("                    BOOK ACCESSION NUMBER : %d\n                    BOOK IDENTIFICATION NUMBER : %s\n",f->BookAccessionNO,f->BookIdentificationNo);
                printf("                    BOOK NAME : %s\n                    BOOK AUTHOR NAME : %s\n",f->BookName,f->BookAuthor);
                printf("                    BOOK SUBJECT : %s\n                    BOOK DESCRIPTION : %s\n",f->BookSubject,f->BookDescription);
                printf("                    BOOK PRICE : %.2f\n                    BOOK COUNT : %d\n",f->BookPrice,f->BookCount);
                printf("                    BOOK LOCATION : %.2f\n",f->BookLocation);
                if(f->BookCount>0)
                                    printf("                    BOOK STATUS : AVAILABLE\n");
                else
                    printf("                    BOOK STATUS : NOT AVAILABLE\n");

            }
            f=f->next;
            SearchCount2++;
        }
           if(BookFoundTrack!=1)
            printf("\n\n                    SORRY !!! BOOK NOT FOUND\n");
            getch();
        break;
    case 2:
         system("cls");
        printf("\n\n\n\n                    *****SEARCH --> BOOK AUTHOR NAME*****\n\n");
        printf("                    ENTER AUTHOR NAME : ");
        f=head;
        gets(Temp3);
        gets(SearchBookAuthor);
     while(SearchCount2<TotalBook)
        {
            if(strcmp(f->BookAuthor,SearchBookAuthor)==0)
            {
                BookFoundTrack=1;
                printf("\n\n                    ***BOOK FOUND***\n\n");
                printf("                    BOOK ACCESSION NUMBER : %d\n                    BOOK IDENTIFICATION NUMBER : %s\n",f->BookAccessionNO,f->BookIdentificationNo);
                printf("                    BOOK NAME : %s\n                    BOOK AUTHOR NAME : %s\n",f->BookName,f->BookAuthor);
                printf("                    BOOK SUBJECT : %s\n                    BOOK DESCRIPTION : %s\n",f->BookSubject,f->BookDescription);
                printf("                    BOOK PRICE : %.2f\n                    BOOK COUNT : %d\n",f->BookPrice,f->BookCount);
                printf("                    BOOK LOCATION : %.2f\n",f->BookLocation);
                if(f->BookCount>0)
                                    printf("                    BOOK STATUS : AVAILABLE\n");
                else
                    printf("                    BOOK STATUS : NOT AVAILABLE\n");

            }
            f=f->next;
            SearchCount2++;
        }
           if(BookFoundTrack!=1)
            printf("\n\n                    SORRY !!! BOOK NOT FOUND\n");
            getch();
        break;
    case 3:
         system("cls");
        printf("\n\n\n\n                    *****SEARCH --> SUBJECT NAME*****\n\n");
        printf("                    ENTER SUBJECT NAME : ");
        f=head;
        gets(Temp3);
        gets(SearchSubject);
     while(SearchCount2<TotalBook)
        {
            if(strcmp(f->BookSubject,SearchSubject)==0)
            {
                BookFoundTrack=1;
                printf("\n\n                    ***BOOK FOUND***\n\n");
                printf("                    BOOK ACCESSION NUMBER : %d\n                    BOOK IDENTIFICATION NUMBER : %s\n",f->BookAccessionNO,f->BookIdentificationNo);
                printf("                    BOOK NAME : %s\n                    BOOK AUTHOR NAME : %s\n",f->BookName,f->BookAuthor);
                printf("                    BOOK SUBJECT : %s\n                    BOOK DESCRIPTION : %s\n",f->BookSubject,f->BookDescription);
                printf("                    BOOK PRICE : %.2f\n                    BOOK COUNT : %d\n",f->BookPrice,f->BookCount);
                printf("                    BOOK LOCATION : %.2f\n",f->BookLocation);
                if(f->BookCount>0)
                                    printf("                    BOOK STATUS : AVAILABLE\n");
                else
                    printf("                    BOOK STATUS : NOT AVAILABLE\n");

            }
            f=f->next;
            SearchCount2++;
        }
           if(BookFoundTrack!=1)
            printf("\n\n                    SORRY !!! BOOK NOT FOUND\n");
            getch();
        break;
    case 4:
          system("cls");
        printf("\n\n\n\n                    *****ALL BOOKS*****\n");
         f=head;
         while(SearchCount2<TotalBook)
         {
             printf("\n                    %d . %s",f->BookAccessionNO,f->BookName);
             f=f->next;
             SearchCount2++;
         }
         getch();
         break;
    case 5:
        return;
    default :
        printf("\n                    INVALID OPTION");
        delay();
        system("cls");
        break;
    }
}
}
void overDue()
{
    printf("\n                         *****MOBILE NOTIFICATION IS SENT TO USERS HAVING BOOKS BEYOND DUE DATE***** \n");
    getch();
}
void deleteBook()
{
  struct library *del,*delprevious;
  char DeleteIdentificationNo[6],Temp5[2];
  int SearchCount=0,DelChoice,BookFoundTrack=0;
  printf("\n\n\n\n                    ***DELETE A BOOK***\n");
  printf("\n                    ENTER BOOK IDENTIFICATION NO : ");
  gets(Temp5);
  gets(DeleteIdentificationNo);
  del=delprevious=head;
  while(SearchCount<TotalBook)
        {
            if(strcmp(del->BookIdentificationNo,DeleteIdentificationNo)==0)
            {
                BookFoundTrack=1;
                printf("                    BOOK ACCESSION NUMBER : %d\n                    BOOK IDENTIFICATION NUMBER : %s\n",del->BookAccessionNO,del->BookIdentificationNo);
                printf("                    BOOK NAME : %s\n                    BOOK AUTHOR NAME : %s\n",del->BookName,del->BookAuthor);
                printf("                    BOOK SUBJECT : %s\n                    BOOK DESCRIPTION : %s\n",del->BookSubject,del->BookDescription);
                printf("                    BOOK PRICE : %.2f\n                    BOOK COUNT : %d\n",del->BookPrice,del->BookCount);
                printf("                    BOOK LOCATION : %.2f\n",del->BookLocation);
                if(del->BookCount>0)
                                    printf("                    BOOK STATUS : AVAILABLE\n");
                else
                    printf("                    BOOK STATUS : NOT AVAILABLE\n");
                 printf("\n                    ***PRESS 1 TO PERMANENTLY DELETE THIS BOOK***\n");
                 printf("\n                    ***PRESS 2 TO CANCEL***        \n");
                 scanf("%d",&DelChoice);
                 if(DelChoice==1)
                 {
                    TotalBook--;
                  if(del==head)
                  {
                      head=del->next;
                       printf("\n                    ***DELETED SUCCESSFULLY***\n");
                       getch();
                      break;
                  }
                  else if(del->next==NULL)
                  {
                      delprevious->next=NULL;
                      printf("\n                    ***DELETED SUCCESSFULLY***\n");
                      getch();
                      return;
                  }
                  else{
                    delprevious->next=del->next;
                    printf("\n                    ***DELETED SUCCESSFULLY***\n");
                    getch();
                    return;
                  }
                 }
                 else if(DelChoice==2)
                 {
                     return;
                 }
            }
            del=del->next;
            if(SearchCount!=0)
            delprevious=delprevious->next;
            SearchCount++;
        }
        if(BookFoundTrack!=1)
            printf("\n\n                    SORRY !!! BOOK NOT FOUND\n");
            getch();
            return;

}
